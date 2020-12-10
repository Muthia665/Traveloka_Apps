package com.muzaaz.travelokaapps.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.muzaaz.travelokaapps.Fragment.AwalFragment
import com.muzaaz.travelokaapps.Fragment.PesananFragment
import com.muzaaz.travelokaapps.Fragment.akunFragment
import com.muzaaz.travelokaapps.Fragment.inboxFragment
import com.muzaaz.travelokaapps.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //buat object buat manggil fragment2 nya, karena kita ngebuat bottom nav nya di main activity jadi harus di panggil dulu
    lateinit var awalFragment: AwalFragment
    lateinit var pesananFragment: PesananFragment
    lateinit var inboxFragment: inboxFragment
    lateinit var akunFragment: akunFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for make fragment default
        awalFragment = AwalFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,awalFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        //setOnNavigationItemSelectedListener = function untuk klik bottom navigation
        bottom_nav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                //ketika di pilih item home, maka akan melakukan ini
                R.id.awal -> {
                    //berasal dari object homeFragment, mau pindah kemana? HomeFragment
                    awalFragment = AwalFragment()
                    //support fragment manager =
                    // Kelas FragmentManager dan kelas FragmentTransaction memungkinkan kita untuk menambah,
                    // menghapus dan menimpa fragment yang ada di layout saat activity sedang aktif.
                    supportFragmentManager.beginTransaction()
                        //replace = menggantikan/menimpa frame layout menjadi fragment home
                        .replace(R.id.frame_layout,awalFragment)
                        // setTransition = melakukan transisi ketika membuka halaman home,
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        //commit = menyetujui / menjalankan
                        .commit()
                }

                R.id.pesanan -> {
                    pesananFragment = PesananFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,pesananFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                R.id.inbox -> {
                    inboxFragment = inboxFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,inboxFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                R.id.akun_saya -> {
                    akunFragment = akunFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,akunFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

            }
            //harus mengembalikan nilai /
            true
        }
    }
}
