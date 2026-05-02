# uts_mobile
📱 Seminar Registration App
📌 Overview

Seminar Registration App adalah aplikasi Android sederhana yang dirancang untuk mempermudah proses pendaftaran seminar secara digital. Aplikasi ini dikembangkan menggunakan Kotlin dengan pendekatan Material Design, serta dilengkapi fitur validasi input, dialog konfirmasi, dan navigasi antar activity yang terstruktur untuk memberikan pengalaman pengguna yang intuitif dan nyaman.

🎯 Objective

Aplikasi ini dikembangkan sebagai bagian dari pemenuhan tugas Ujian Tengah Semester (UTS) dengan fokus pada implementasi konsep dasar pengembangan aplikasi mobile, meliputi:

Penerapan prinsip Material Design
Validasi input pengguna secara sistematis
Penggunaan dialog konfirmasi sebelum proses submit
Penampilan data hasil input secara jelas dan informatif
🧩 Core Features
🔐 Authentication (Login)
Sistem login sederhana berbasis data statis (hardcoded)
Kredensial default:
Username: admin
Password: 123
Penyimpanan data pengguna menggunakan SharedPreferences
📝 Registration
Menyediakan form registrasi dasar bagi pengguna baru
Setelah proses registrasi selesai, pengguna diarahkan kembali ke halaman login
🏠 Main Page
Menampilkan identitas pengguna yang sedang login
Menyediakan akses langsung ke halaman pendaftaran seminar
📋 Registration Form

Pengguna diminta untuk mengisi data berikut:

Nama lengkap
Email
Nomor HP
Jenis kelamin (RadioButton)
Pilihan seminar (Spinner)
Persetujuan data (Checkbox)
⚠️ Input Validation

Untuk menjaga kualitas data, aplikasi menerapkan validasi sebagai berikut:

Seluruh field wajib diisi
Format email harus mengandung simbol “@”
Nomor HP harus memenuhi kriteria:
Hanya terdiri dari angka
Diawali dengan “08”
Memiliki panjang antara 8 hingga 12 digit
Jenis kelamin harus dipilih
Checkbox persetujuan wajib dicentang

Validasi juga dilakukan secara real-time menggunakan TextWatcher, sehingga pengguna mendapatkan feedback langsung saat mengisi form.

💬 Confirmation Dialog

Sebelum data dikirim, sistem akan menampilkan dialog konfirmasi dengan pesan:

“Apakah data yang Anda masukkan sudah benar?”

Pilihan yang tersedia:

Ya → Melanjutkan ke halaman hasil
Tidak → Kembali ke form untuk melakukan perbaikan
📊 Result Page

Menampilkan ringkasan data yang telah diinput oleh pengguna, meliputi:

Nama
Email
Nomor HP
Jenis kelamin
Seminar yang dipilih

Disediakan tombol navigasi untuk kembali ke halaman utama.

🔄 Application Flow

Login → Main → Form → Confirmation → Result → Main

🧠 Technologies Used
Kotlin
Android Studio
Material Design Components
SharedPreferences
Intent (activity navigation)
AlertDialog
TextWatcher (real-time validation)
Regex (phone number validation)
⚙️ How to Run
Buka project melalui Android Studio
Tunggu proses build Gradle hingga selesai
Jalankan aplikasi menggunakan emulator atau perangkat fisik
Gunakan akun berikut untuk login:
Username: admin
Password: 123
🎥 Demo

Demo aplikasi dapat diakses melalui video berikut:

👉 (https://drive.google.com/file/d/1YVk76kvp9AiUWCPhVxpKcxDBdso8nyxM/view?usp=sharing)

👨‍💻 Author

Nama: M. Belga Ghifari
Kelas: TIF K 24 A
NIM: 24552011078
Mata Kuliah: Pemrograman Mobile 1
