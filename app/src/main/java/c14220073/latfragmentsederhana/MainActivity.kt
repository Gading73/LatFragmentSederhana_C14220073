package c14220073.latfragmentsederhana

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFragmentSatu = findViewById<Button>(R.id.btnFragmentSatu)
        val btnFragmentDua = findViewById<Button>(R.id.btnFragmentDua)

        // Menampilkan fSatu secara otomatis saat aplikasi pertama kali dimuat
        if (savedInstanceState == null) {
            replaceFragment(fSatu())
        }


    }

    // Fungsi untuk membongkar-pasang Fragment di dalam container
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}