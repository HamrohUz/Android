package uz.hamroh.trip.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen
import uz.hamroh.trip.ui.main.TripFragment

object TripDestinations {
    fun Main() = FragmentScreen { TripFragment() }
}