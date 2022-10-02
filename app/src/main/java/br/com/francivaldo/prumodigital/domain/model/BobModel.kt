package br.com.francivaldo.prumodigital.domain.model
class BobModel {
    private var outSize = 0
    var x = 0f
    var y = 0f
    fun setBaseSize(n:Int){
        outSize = n*5
    }
    fun updateX(_x:Float){
        x = (outSize.toFloat()/2) * _x
    }
    fun updateY(_y:Float){
        y = (outSize.toFloat()/2) * _y
    }
}