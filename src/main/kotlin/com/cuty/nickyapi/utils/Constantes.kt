package com.cuty.nickyapi.utils

class Constantes {
    companion object{
        private const val URL_API_BASE= "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION

        //BASE ENDPOINT PARA ITEMS DE LA CARTA
        const val URL_BASE_ITEMSCARTA = "$URL_BASE/itemscarta"
    }
}