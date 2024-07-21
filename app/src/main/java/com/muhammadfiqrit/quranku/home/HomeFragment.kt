package com.muhammadfiqrit.quranku.home

import android.content.Intent
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal.JadwalDataHarian
import com.muhammadfiqrit.quranku.databinding.FragmentHomeBinding
import com.muhammadfiqrit.quranku.doa.activity.DoaActivity
import com.muhammadfiqrit.quranku.husna.HusnaActivity
import com.muhammadfiqrit.quranku.lokasi.LokasiViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Locale


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val lokasiViewModel: LokasiViewModel by viewModel()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.asmahulHusna.setOnClickListener {
            val intent = Intent(requireContext(), HusnaActivity::class.java)
            startActivity(intent)

        }
        binding.doa.setOnClickListener {
            val intent = Intent(requireContext(), DoaActivity::class.java)
            startActivity(intent)
        }

        val gregorianCalendar = GregorianCalendar()
        val calendarYear = gregorianCalendar.get(Calendar.YEAR)
        val calendarMonth = gregorianCalendar.get(Calendar.MONTH) + 1
        val calendarDay = gregorianCalendar.get(Calendar.DAY_OF_MONTH)
        Log.e("gregorian", calendarDay.toString())
        lokasiViewModel.lokasiSekarang.observe(viewLifecycleOwner) { lokasi ->
            if (lokasi != null) {
                populateData("$calendarYear-$calendarMonth-$calendarDay", lokasi.idLokasi!!.toInt())
            }
        }

    }

    fun populateData(tanggal: String, idKota: Int) {
        homeViewModel.setIdKota(idKota)
        homeViewModel.setTanggal(tanggal)
        homeViewModel.jadwalSholatHarian.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        bindingData(it)
                        countDownWaktuSholat(it)

                    }

                    is Resource.Error -> {
                        Log.e("error", "${it.message}")
                        Toast.makeText(requireActivity(), "${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    private fun bindingData(data: Resource.Success<JadwalDataHarian>) {
        binding.tvWaktuAsr.text = data.data?.ashar
        binding.tvWaktuFajr.text = data.data?.subuh
        binding.tvWaktuIsya.text = data.data?.isya
        binding.tvWaktuDzuhur.text = data.data?.dzuhur
        binding.tvWaktuMaghrib.text = data.data?.maghrib
        binding.tvLokasi.text = data.data?.daerah
        binding.tvTanggalSekarang.text = data.data?.tanggal
    }

    private fun countDownWaktuSholat(data: Resource.Success<JadwalDataHarian>) {
        val jadwalSholat =
            mapOf(
                "subuh" to data.data?.subuh,
                "dzuhur" to data.data?.dzuhur,
                "ashar" to data.data?.ashar,
                "maghrib" to data.data?.maghrib,
                "isya" to data.data?.isya
            )


        val currentTime = Calendar.getInstance()
        val nextPrayerTime = getNextPrayerTime(jadwalSholat, currentTime)

        // Calculate time difference
        val diffInMillis = nextPrayerTime.timeInMillis - currentTime.timeInMillis

        Log.e("diffInMillis", diffInMillis.toString())


        startCountDown(diffInMillis)


    }

    private fun getNextPrayerTime(
        jadwalSolat: Map<String, String?>,
        currentTime: Calendar
    ): Calendar {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        var nextPrayerTime = Calendar.getInstance()

        // Iterate through prayer times to find the next one
        for ((_, time) in jadwalSolat) {
            val prayerTime = sdf.parse(time) ?: continue
            val prayerCalendar = Calendar.getInstance()
            prayerCalendar.time = prayerTime


            // Set prayer time to today's date
            prayerCalendar.set(Calendar.YEAR, currentTime.get(Calendar.YEAR))
            prayerCalendar.set(Calendar.MONTH, currentTime.get(Calendar.MONTH))
            prayerCalendar.set(Calendar.DAY_OF_MONTH, currentTime.get(Calendar.DAY_OF_MONTH))
            Log.e("time", currentTime.time.toString())

            // If current time is before prayer time, this is the next prayer
            if (sdf.format(currentTime.time) < time!!) {
                nextPrayerTime = prayerCalendar
                break
            }
        }

        // If no prayer time found for today, get the first prayer time for tomorrow
        if (nextPrayerTime.timeInMillis <= currentTime.timeInMillis) {
            val firstPrayerTimeTomorrow = jadwalSolat.entries.first()
            val tomorrow = Calendar.getInstance()
            tomorrow.add(Calendar.DAY_OF_MONTH, 1)
            val prayerTimeTomorrow = sdf.parse(firstPrayerTimeTomorrow.value) ?: currentTime.time
            nextPrayerTime = Calendar.getInstance()
            nextPrayerTime.time = prayerTimeTomorrow
            nextPrayerTime.set(Calendar.YEAR, tomorrow.get(Calendar.YEAR))
            nextPrayerTime.set(Calendar.MONTH, tomorrow.get(Calendar.MONTH))
            nextPrayerTime.set(Calendar.DAY_OF_MONTH, tomorrow.get(Calendar.DAY_OF_MONTH))

            /*  Log.e("nextPrayerTime",nextPrayerTime.time.toString())
              Log.e("nextPrayerTime",currentTime.time.toString())*/
        }

        return nextPrayerTime
    }


    private fun startCountDown(milliseconds: Long) {
        object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = (millisUntilFinished / 1000) % 60
                val minutes = (millisUntilFinished / (1000 * 60)) % 60
                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
                binding.tvCountdownTimer.text =
                    String.format("%02d:%02d:%02d".format(hours, minutes, seconds))
            }

            override fun onFinish() {
                /*               val gregorianCalendar = GregorianCalendar()
                               val calendarYear = gregorianCalendar.get(Calendar.YEAR)
                               val calendarMonth = gregorianCalendar.get(Calendar.MONTH) + 1
                               val calendarDay = gregorianCalendar.get(Calendar.DAY_OF_MONTH)
                               Log.e("gregorian", calendarDay.toString())
                               populateData("$calendarYear-$calendarMonth-$calendarDay", 1301)*/
            }

        }.start()
    }

}