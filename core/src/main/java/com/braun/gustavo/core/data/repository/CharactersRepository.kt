package com.braun.gustavo.core.data.repository

import androidx.paging.PagingSource
import com.braun.gustavo.core.domain.model.Character

interface CharactersRepository {

    fun getCharacters(query: String): PagingSource<Int, Character>

}