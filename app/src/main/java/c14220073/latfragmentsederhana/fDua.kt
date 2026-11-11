package c14220073.latfragmentsederhana

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class fDua : Fragment(R.layout.fragment_f_dua) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvHasil = view.findViewById<TextView>(R.id.tvHasil)
        val btnOpenFDua = view.findViewById<Button>(R.id.btnOpenFDua)

        // Membongkar paket data yang dikirimkan dari fSatu
        arguments?.let {
            val namaDiterima = it.getString("Nama") ?: ""
            val alamatDiterima = it.getString("Alamat") ?: ""

            // Memproyeksikan data ke layar jika paket tidak kosong
            if (namaDiterima.isNotEmpty()) {
                tvHasil.text = "Halo $namaDiterima!\nAlamat Anda $alamatDiterima"
            }
        }

        // Logika untuk kembali ke fSatu saat tombol ditekan
        btnOpenFDua.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fSatu())
            fragmentTransaction.commit()
        }
    }
}