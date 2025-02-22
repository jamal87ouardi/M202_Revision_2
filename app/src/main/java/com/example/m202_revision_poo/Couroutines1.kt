package com.example.m202_revision_poo

import kotlinx.coroutines.*

fun main() = runBlocking {
    // Coroutine 1 : Simule une tâche de téléchargement
    val job1 = launch {
        println("Téléchargement de données en cours...")
        delay(2000L) // Simuler une tâche longue (2 secondes)
        println("Téléchargement terminé!")
    }

    // Coroutine 2 : Simule un calcul
    val job2 = launch {
        println("Calcul en cours...")
        delay(1500L) // Simuler un calcul qui prend 1,5 secondes
        println("Calcul terminé!")
    }

    // Coroutine 3 : Simule une tâche d'initialisation
    val job3 = launch {
        println("Initialisation des composants...")
        delay(1000L) // Simuler une initialisation rapide (1 seconde)
        println("Initialisation terminée!")
    }

    // Attendre que toutes les coroutines se terminent
    job1.join()
    job2.join()
    job3.join()

    println("Toutes les coroutines sont terminées.")
}
