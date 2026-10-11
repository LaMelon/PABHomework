#!/usr/init/env python3
"""
Modul Pembuatan Dataset Akuntansi (Accounting Dataset Generation)
Dibuat modular agar dapat dieksekusi secara mandiri via CLI atau Ansible.
"""

import sys
import os
import pandas as pd

def read_raw_data(input_folder: str) -> list:
    """
    Membaca setiap file data mentah dari folder input yang ditentukan.
    """
    if not os.path.exists(input_folder):
        raise FileNotFoundError(f"Folder input '{input_folder}' tidak ditemukan.")
        
    raw_files = []
    for filename in os.listdir(input_folder):
        file_path = os.path.join(input_folder, filename)
        if os.path.isfile(file_path):
            raw_files.append((filename, file_path))
            
    print(f"Berhasil membaca {len(raw_files)} file data mentah dari {input_folder}")
    return raw_files

def convert_to_dataset(raw_data_item: tuple) -> pd.DataFrame:
    """
    Mengonversi item data mentah tunggal (file CSV) menjadi format dataset terstruktur (DataFrame).
    """
    filename, file_path = raw_data_item
    try:
        # Membaca file CSV mentah
        df = pd.read_csv(file_path)
        print(f"Berhasil mengonversi file: {filename}")
        return df
    except Exception as e:
        print(f"Gagal memproses file {filename}: {e}")
        return pd.DataFrame()

def merge_dataset(datasets: list) -> pd.DataFrame:
    """
    Menggabungkan beberapa dataset terstruktur menjadi satu dataset tunggal.
    """
    if not datasets:
        return pd.DataFrame()
        
    # Menggabungkan seluruh DataFrame secara vertikal
    merged_df = pd.concat(datasets, ignore_index=True)
    print(f"Berhasil menggabungkan {len(datasets)} dataset.")
    return merged_df

def main():
    """
    Fungsi utama Command-Line Interface (CLI) untuk Ansible.
    Format: python3 accounting/dataset_generation.py <input_folder> <output_folder>
    """
    if len(sys.argv) != 3:
        print("Penggunaan: python3 dataset_generation.py <input_folder> <output_folder>")
        sys.exit(1)
        
    input_folder = sys.argv[1]
    output_folder = sys.argv[2]
    
    # Membuat folder output jika belum ada
    os.makedirs(output_folder, exist_ok=True)
    
    # Menjalankan rangkaian proses (pipeline)
    raw_data_list = read_raw_data(input_folder)
    datasets = [convert_to_dataset(item) for item in raw_data_list]
    final_dataset = merge_dataset(datasets)
    
    # Menyimpan hasil akhir ke file CSV di folder output
    output_file_path = os.path.join(output_folder, "final_dataset.csv")
    final_dataset.to_csv(output_file_path, index=False)
    
    print(f"Dataset CSV akhir berhasil dibuat di: {output_file_path}")

if __name__ == "__main__":
    main()