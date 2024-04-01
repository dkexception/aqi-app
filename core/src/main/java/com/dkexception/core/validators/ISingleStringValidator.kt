package com.dkexception.core.validators

import com.dkexception.core.model.RootError
import com.dkexception.core.model.TaskResult

fun interface ISingleStringValidator {

    operator fun invoke(dataToValidate: String): TaskResult<Unit, RootError>
}
