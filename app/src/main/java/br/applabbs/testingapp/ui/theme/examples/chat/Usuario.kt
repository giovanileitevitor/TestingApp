package br.applabbs.testingapp.ui.theme.examples.chat

import br.applabbs.testingapp.R

data class Usuario(
    val nome: String? = null,
    val foto: Int? = null
)

fun fakeUsers(): MutableList<Usuario>{
    val users = mutableListOf<Usuario>()

    for (i in 0..5){
        users.add(
            Usuario(nome = "Joao Jose Jesus", foto = R.drawable.city),
        )
    }


    return users
}
