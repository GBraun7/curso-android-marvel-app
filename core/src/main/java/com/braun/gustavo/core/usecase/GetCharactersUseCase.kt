package com.braun.gustavo.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.braun.gustavo.core.data.repository.CharactersRepository
import com.braun.gustavo.core.domain.model.Character
import com.braun.gustavo.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersUseCase.GetCharactersUseCase, Character>() {

    override fun createFlowObservable(params: GetCharactersUseCase): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig) {
            charactersRepository.getCharacters(params.query)
        }.flow
    }

    data class GetCharactersUseCase(val query: String, val pagingConfig: PagingConfig)
}