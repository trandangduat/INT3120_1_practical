fun main() {
    val phone: Phone = FoldablePhone(isScreenLightOn = false)
    
    if (phone is FoldablePhone) phone.foldPhone()
    phone.switchOn()
    phone.checkPhoneScreenLight()
    
    if (phone is FoldablePhone) phone.unfoldPhone()
    phone.switchOn()
    phone.checkPhoneScreenLight()
}


open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(isScreenLightOn: Boolean) : Phone(isScreenLightOn = isScreenLightOn) {
    var isFolded: Boolean = false
    	set(value) {
            field = value
        }
    
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }
    
	fun foldPhone() {
        isFolded = true
    }
    
    fun unfoldPhone() {
        isFolded = false
    }
}