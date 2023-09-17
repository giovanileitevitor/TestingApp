package br.applabbs.testingapp.ui.theme.examples.chat

import br.applabbs.testingapp.R

data class Usuario(
    val nome: String? = null,
    val foto: Int? = null
)

fun fakeUsers(qtd: Int): MutableList<Usuario>{
    val users = mutableListOf<Usuario>()

    for (i in 0..qtd){
        users.add(
            Usuario(nome = " $i - Joao Jose Jesus", foto = R.drawable.city),
        )
    }


    return users
}

fun fakeUser(): Usuario{
    return Usuario(
        nome = "Joao josé Jesus",
        foto = R.drawable.city
    )
}
