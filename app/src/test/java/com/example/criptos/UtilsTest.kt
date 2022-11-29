package com.example.criptos

import com.example.criptos.data.utils.formatAsCurrency
import junit.framework.Assert.assertEquals
import org.junit.Test

class UtilsTest {
    @Test
    fun `formatted Double value into currency`() {
        // Given
        val bookCodeStr: Double = 300.00

        // When
        val result = bookCodeStr.formatAsCurrency()

        // Then
        assertEquals(result, "$300.00")
    }
}