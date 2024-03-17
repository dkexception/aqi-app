package com.dkexception.aqiapp.feature.onboarding.guide

import com.dkexception.core.base.mvi.BaseScreenEvent

sealed class GuideEvent: BaseScreenEvent() {

    data object OnSkipClicked : GuideEvent()

    data object OnGetStartedClicked : GuideEvent()
}
