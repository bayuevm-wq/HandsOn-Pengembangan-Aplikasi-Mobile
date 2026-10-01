// Hands-on 1: Class & Inheritance
// Tugas: Buat hierarki class kendaraan menggunakan open class, primary constructor,
// dan override fungsi. Vehicle adalah base class, Car dan Motorcycle adalah turunannya.

// TODO 1: Jadikan class ini "open" agar bisa diturunkan (inherited).
// Primary constructor sudah punya property name (val) dan maxSpeed (val, dalam km/h).
open class Vehicle(val name: String, val maxSpeed: Int) {
    open fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h"
    }
}

// TODO 3: Buat class Car sebagai turunan dari Vehicle.
// Constructor Car menerima name dan jumlah pintu (numberOfDoors: Int),
// lalu meneruskan (name, maxSpeed = 180) ke constructor Vehicle.
// Override describe() untuk menambahkan info jumlah pintu, contoh:
// "Toyota dapat melaju hingga 180 km/h dan punya 4 pintu"

class Car(name: String, val numberOfDoors: Int) : Vehicle(name, 180) {
    override fun describe(): String {
        return "${super.describe()} dan punya $numberOfDoors pintu"
    }
}

class Motorcycle(name: String, val hasSidecar: Boolean) : Vehicle(name, 220) {
    override fun describe(): String {
        val sidecarText = if (hasSidecar) "dengan sidecar" else "tanpa sidecar"
        return "${super.describe()} ($sidecarText)"
    }
}

fun main() {
    val vehicles = listOf<Vehicle>(
        Car("Toyota", numberOfDoors = 4),
        Motorcycle("Ninja", hasSidecar = false)
    )

    // Polymorphism: setiap elemen dipanggil lewat interface Vehicle,
    // tapi describe() yang jalan adalah versi milik subclass masing-masing.
    vehicles.forEach { println(it.describe()) }
}
