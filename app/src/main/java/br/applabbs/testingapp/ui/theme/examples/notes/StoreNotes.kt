package br.applabbs.testingapp.ui.theme.examples.notes

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreNotes(private val context: Context) {

    companion object{
        private val Context.datStore: DataStore<Preferences> by preferencesDataStore("configuracoes")
        val ANOTATION_KEY = stringPreferencesKey("note")
    }

    val getNote: Flow<String> = context.datStore.data.map { preferences ->
        preferences[ANOTATION_KEY] ?: ""
    }

    suspend fun saveNote(note: String){
        context.datStore.edit { preferences ->
            preferences[ANOTATION_KEY] = note
        }
    }

    suspend fun getNote(): String{
        return ""
    }

}