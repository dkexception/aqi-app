package com.dkexception.core.validators

import android.util.Patterns
import com.dkexception.core.model.EmailValidationError
import com.dkexception.core.model.TaskResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class LoginEmailValidator @Inject constructor() : ISingleStringValidator {

    override operator fun invoke(dataToValidate: String): TaskResult<Unit, EmailValidationError> {

        if (dataToValidate.isBlank()) {
            return TaskResult.Error(EmailValidationError.EMPTY)
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(dataToValidate).matches()) {
            return TaskResult.Error(EmailValidationError.INCORRECT)
        }

        return TaskResult.Success(Unit)
    }
}
