package com.igor.data.provider

import android.content.res.Resources
import com.igor.data.R

class StringProvider : StringProviderInterface {

    //TODO get from strings
    override val baseUrl: String
        get() = "https://api-simulator-calc.easynvest.com.br/"//Resources.getSystem().getString(R.string.base_url)

}