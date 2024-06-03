package uz.hamroh.ui.util

import androidx.annotation.StringRes
import uz.hamroh.ui.R

enum class ValidationResultType(@StringRes val resId: Int) {
    ACCEPTED(R.string.validation_result_accepted),
    LENGTH_SHORT(R.string.validation_result_length_short),
    AT_LEAST_ONE_UPPER_CASE_SYMBOL(R.string.validation_result_at_least_one_upper_case_symbol),
    EMAIL_IS_NOT_CORRECT(R.string.validation_result_incorrect_email),
    AT_LEAST_ONE_NUMBER(R.string.validation_result_at_least_one_number),
    DO_NOT_MATCHED(R.string.validation_result_do_not_matched),
    EMPTY(R.string.validation_result_empty),
    INCORRECT_DATE(R.string.validation_result_incorrect_date)
}