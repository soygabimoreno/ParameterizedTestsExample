package soy.gabimoreno.parameterizedtestsexample

import org.amshove.kluent.shouldBe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class IsValidEmailUseCaseTest(
    private val email: String,
    private val expected: Boolean,
) {

    private lateinit var useCase: IsValidEmailUseCase

    @Before
    fun setUp() {
        useCase = IsValidEmailUseCase()
    }

    @Test
    fun `GIVEN an email WHEN invoke THEN get the expected result`() {
        val result = useCase(email)

        result shouldBe expected
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "email: {0} expected: {1}")
        fun data() = listOf(
            arrayOf("foo", false),
            arrayOf("foo@", false),
            arrayOf("foo@foo", false),
            arrayOf("foo@foo.", false),
            arrayOf("foo@foo.com", true),
        )
    }
}
