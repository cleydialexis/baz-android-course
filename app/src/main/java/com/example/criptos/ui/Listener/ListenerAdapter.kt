package com.example.criptos.ui.Listener

import com.example.criptos.domain.repository.model.Book

interface ListenerAdapter {
    fun listener(book: Book)
}