package c14220073.latfragmentsederhana

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

// Arsitektur yang lebih bersih: melempar layout langsung via konstruktor
class fSatu : Fragment(R.layout.fragment_f_satu) {

    // onViewCreated digunakan untuk mengaitkan elemen UI setelah layout XML selesai dimuat
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOpenFSatu = view.findViewById<Button>(R.id.btnOpenFSatu)

        // Logika saat tombol ditekan
        btnOpenFSatu.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            val fragmentDua = fDua()

            // Membungkus data yang akan dikirim
            val dataKirim = Bundle().apply {
                putString("Nama", "Andi")
                putString("Alamat", "Siwalankerto")
            }
            fragmentDua.arguments = dataKirim

            // Mengeksekusi transisi penggantian halaman
            fragmentTransaction.replace(R.id.fragment_container, fragmentDua)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}