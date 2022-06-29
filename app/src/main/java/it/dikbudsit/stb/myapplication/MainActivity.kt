package it.dikbudsit.stb.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import it.dikbudsit.stb.myapplication.databinding.ActivityMainBinding
import it.dikbudsit.stb.myapplication.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.btnPrev.visibility = View.GONE /*di awal btnprev ngilang/ gak bisa dipencet*/
                        binding.btnNext.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.btnPrev.visibility = View.VISIBLE /*halaman berikutnya btn prev nongol/ bisa dipencet*/
                        binding.btnNext.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.btnPrev.visibility = View.VISIBLE
                        binding.btnNext.visibility = View.GONE /*halaman terkahir btnNext yg ngilang*/
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        binding.btnPrev.visibility = View.GONE
        binding.btnNext.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true);
        }
        binding.btnPrev.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)
        }


    }
}