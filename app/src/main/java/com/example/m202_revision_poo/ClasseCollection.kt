package com.example.m202_revision_poo

fun main() {
    // Créer une MutableList avec des valeurs initiales
    val list = mutableListOf(1, 2, 3, 4, 5)

    // Ajouter un élément à la fin
    list.add(6)
    println("Après ajout de 6: $list")

    // Ajouter un élément à une position spécifique
    list.add(2, 10) // Ajoute 10 à l'index 2
    println("Après ajout de 10 à l'index 2: $list")

    // Modifier un élément à une position spécifique
    list[3] = 20
    println("Après modification de l'élément à l'index 3: $list")

    // Supprimer un élément par valeur
    list.remove(4) // Supprime le premier 4 trouvé
    println("Après suppression de 4: $list")

    // Supprimer un élément à une position spécifique
    list.removeAt(1) // Supprime l'élément à l'index 1
    println("Après suppression de l'élément à l'index 1: $list")

    // Vérifier si un élément existe dans la liste
    val contains5 = list.contains(5)
    println("La liste contient 5 : $contains5")

    // Obtenir un élément à une position spécifique
    val elementAt2 = list[2]
    println("L'élément à l'index 2 : $elementAt2")

    // Trier la liste
    list.sort()
    println("Liste triée : $list")

    // Inverser la liste
    list.reverse()
    println("Liste inversée : $list")

    // Obtenir la taille de la liste
    println("Taille de la liste : ${list.size}")
}
