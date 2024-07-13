package com.muhammadfiqrit.quranku.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.muhammadfiqrit.quranku.R
import com.muhammadfiqrit.quranku.lokasi.LokasiFragment
import com.muhammadfiqrit.quranku.databinding.ActivityMainBinding
import com.muhammadfiqrit.quranku.favorite.FavoriteFragment
import com.muhammadfiqrit.quranku.home.HomeFragment
import com.muhammadfiqrit.quranku.surat.SuratFragment
import com.muhammadfiqrit.quranku.utils.Utilities

class MainActivity : AppCompatActivity() {

    private var selectedTab: Int = 1
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f


        Utilities.setStatusBarGradiant(this)
        supportFragmentManager.beginTransaction().setReorderingAllowed(true)
            .replace(R.id.fragment_container_view, HomeFragment(), null).commit()
        binding.homeLayout.setOnClickListener {

            //check if home tab is already selected or not
            if (selectedTab != 1) {

                //set home fragment

                supportFragmentManager.beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, HomeFragment(), null).commit()

                //unselect other tabs expect home tab
                binding.tvQuran.visibility = View.GONE
                binding.tvBookmark.visibility = View.GONE
                binding.tvLocation.visibility = View.GONE

                binding.ivQuran.setImageResource(R.drawable.ic_quran)
                binding.ivBookmark.setImageResource(R.drawable.ic_bookmark)
                binding.ivLocation.setImageResource(R.drawable.ic_location)

                binding.quranLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                binding.bookmarkLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                binding.locationLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                //select home tab
                binding.tvHome.visibility = View.VISIBLE
                binding.ivHome.setImageResource(R.drawable.ic_selected_home)
                binding.homeLayout.setBackgroundResource(R.drawable.round_back_100)

                //create animation
                val scaleAnimation = ScaleAnimation(
                    0.8f,
                    1.0f,
                    1f,
                    1f,
                    Animation.RELATIVE_TO_SELF,
                    0.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                binding.homeLayout.startAnimation(scaleAnimation)

                //selected tab
                selectedTab = 1
            }



        }
        binding.quranLayout.setOnClickListener {

            //set quran fragment
            supportFragmentManager.beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, SuratFragment(), null).commit()

            //check if quran tab is already selected or not
            if (selectedTab != 2) {
                //unselect other tabs expect home tab
                binding.tvHome.visibility = View.GONE
                binding.tvBookmark.visibility = View.GONE
                binding.tvLocation.visibility = View.GONE

                binding.ivHome.setImageResource(R.drawable.ic_home)
                binding.ivBookmark.setImageResource(R.drawable.ic_bookmark)
                binding.ivLocation.setImageResource(R.drawable.ic_location)

                binding.homeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                binding.bookmarkLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                binding.locationLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                //select home tab
                binding.tvQuran.visibility = View.VISIBLE
                binding.ivQuran.setImageResource(R.drawable.ic_selected_quran)
                binding.quranLayout.setBackgroundResource(R.drawable.round_back_100)

                //create animation
                val scaleAnimation = ScaleAnimation(
                    0.8f,
                    1.0f,
                    1f,
                    1f,
                    Animation.RELATIVE_TO_SELF,
                    1.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                binding.quranLayout.startAnimation(scaleAnimation)

                //selected tab
                selectedTab = 2
            }

        }

            binding.bookmarkLayout.setOnClickListener {

                //set BookmarK fragment
                supportFragmentManager.beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, FavoriteFragment(), null).commit()

                //check if bookmark is already selected or not
                if (selectedTab != 3) {
                    //unselect other tabs expect home tab
                    binding.tvQuran.visibility = View.GONE
                    binding.tvHome.visibility = View.GONE
                    binding.tvLocation.visibility = View.GONE

                    binding.ivQuran.setImageResource(R.drawable.ic_quran)
                    binding.ivHome.setImageResource(R.drawable.ic_home)
                    binding.ivLocation.setImageResource(R.drawable.ic_location)

                    binding.quranLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                    binding.homeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                    binding.locationLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                    //select home tab
                    binding.tvBookmark.visibility = View.VISIBLE
                    binding.ivBookmark.setImageResource(R.drawable.ic_selected_bookmark)
                    binding.bookmarkLayout.setBackgroundResource(R.drawable.round_back_100)

                    //create animation
                    val scaleAnimation = ScaleAnimation(
                        0.8f,
                        1.0f,
                        1f,
                        1f,
                        Animation.RELATIVE_TO_SELF,
                        1.0f,
                        Animation.RELATIVE_TO_SELF,
                        0.0f
                    )
                    scaleAnimation.duration = 200
                    scaleAnimation.fillAfter = true
                    binding.bookmarkLayout.startAnimation(scaleAnimation)

                    //selected tab
                    selectedTab = 3
                }
            }

            binding.locationLayout.setOnClickListener {
                supportFragmentManager.beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, LokasiFragment(), null).commit()
                if (selectedTab != 4) {
                    binding.tvQuran.visibility = View.GONE
                    binding.tvHome.visibility = View.GONE
                    binding.tvBookmark.visibility = View.GONE

                    binding.ivQuran.setImageResource(R.drawable.ic_quran)
                    binding.ivHome.setImageResource(R.drawable.ic_home)
                    binding.ivBookmark.setImageResource(R.drawable.ic_bookmark)

                    binding.quranLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                    binding.bookmarkLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))
                    binding.homeLayout.setBackgroundColor(resources.getColor(android.R.color.transparent))

                    binding.tvLocation.visibility = View.VISIBLE
                    binding.ivLocation.setImageResource(R.drawable.ic_selected_location)
                    binding.locationLayout.setBackgroundResource(R.drawable.round_back_100)

                    val scaleAnimation = ScaleAnimation(
                        0.8f,
                        1.0f,
                        1f,
                        1f,
                        Animation.RELATIVE_TO_SELF,
                        1.0f,
                        Animation.RELATIVE_TO_SELF,
                        0.0f
                    )
                    scaleAnimation.duration= 200
                    scaleAnimation.fillAfter= true
                    binding.locationLayout.startAnimation(scaleAnimation)


                    selectedTab = 4

                }
            }


        }
    }
