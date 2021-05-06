

fun main() {
    val convert = NumberToWords()

    println(convert.convertLessThanOneThousand(0))
    println("*** " + convert.convertLessThanOneThousand(4))
    println("*** " + convert.convertLessThanOneThousand(11))
    println("*** " + convert.convertLessThanOneThousand(17))
    println("*** " + convert.convertLessThanOneThousand(37))
    println("*** " + convert.convertLessThanOneThousand(40))
    println("*** " + convert.convertLessThanOneThousand(90))
    println("*** " + convert.convertLessThanOneThousand(99))
    println("*** " + convert.convertLessThanOneThousand(100))
    println("*** " + convert.convertLessThanOneThousand(199))
    println("*** " + convert.convertLessThanOneThousand(307))
    println("*** " + convert.convertLessThanOneThousand(316))
    println("*** " + convert.convertLessThanOneThousand(328))
    println("*** " + convert.convertLessThanOneThousand(400))
    println("*** " + convert.convertLessThanOneThousand(409))
    println("*** " + convert.convertLessThanOneThousand(890))
    println("*** " + convert.convertLessThanOneThousand(989))
    println("*** " + convert.convertLessThanOneThousand(901))
    println("*** " + convert.convertLessThanOneThousand(999))
    println("*** " + convert.convertLessThanOneThousand(1000))




}

class NumberToWords {

    private val tens = arrayOf(
        "",
        "",
        "ოც",
        "ოც",
        "ორმოც",
        "ორმოც",
        "სამოც",
        "სამოც",
        "ოთხმოც",
        "ოთხმოც"
    )
    private val ones = arrayOf(
        "",
        "ერთი",
        "ორი",
        "სამი",
        "ოთხი",
        "ხუთი",
        "ექვსი",
        "შვიდი",
        "რვა",
        "ცხრა",
        "ათი",
        "თერტმეტი",
        "თორმეტი",
        "ცამმეტი",
        "თოთხმეტი",
        "თხუთმეტი",
        "თექვსმეტი",
        "ჩვიდმეტი",
        "თვრამმეტი",
        "ცხრამმეტი"
    )
    private val ones2 = arrayOf(
        "",
        "",
        "ორ",
        "სამ",
        "ოთხ",
        "ხუთ",
        "ექვს",
        "შვიდ",
        "რვა",
        "ცხრა",
        "ათ"
    )


    private fun convertZeroToHundred(number: Int): String {
        val dozens = number / 10
        var unit = number % 10
        val result: String
        when (dozens) {
            1, 3, 5, 7, 9 -> unit += 10
            else -> {
            }
        }

        // დამაკავშირებლები "ი" "და"  ""
        var wordConnector = ""
        if (dozens > 1) {
            wordConnector = "და"
        }
        when (unit) {
            0 -> wordConnector = "ი"
            1 -> wordConnector = if (dozens == 4) {
                "და"
            } else {
                ""
            }
            11 -> if (dozens == 7) {
                wordConnector = "და"
            }
            else -> {
            }
        }
        result = when (dozens) {
            0 -> ones[unit]
            8 -> if (unit == 0) {
                tens[dozens]
            } else {
                tens[dozens] + wordConnector + ones[unit]
            }
            else -> tens[dozens] + wordConnector + ones[unit]
        }
        return result
    }

    /* ფუნქცია სიტყვიერად წერს 1000 ის ჩათვლით ყველა რიცხვს. 100-ზე გაყოფით გიგებთ რიცხვი 100-ზე
    * მეტია თუ არა თუ შედეგი 0 -ია ესეიგი რიცხვი 100-ზე ნაკლებია და ვიძახებთ lessThanHundreds
    * მეთოდს რომელიც 100-მდე რიცხვებს წერს სიტყვიერად. იგივე რიცხვის % 100 ვიგებთ უკვე რიცხვის
    * ერთეულ ნაწილს, რომ შესაბამისი ქართული სიტყვა მივუსადაგოთ, რადგან ქართული
    * დათვლა კომპლექსურია გვჭირდება IF - ით შემოწმება, რომ თუ მოდულით მიღებული ერთეული ნულია ანუ რიცხვი
    * შეიძლება იყოს 100, 200, 300, 400 ... 1000 წავა შესაბამისი სტრინგი თუ არადა სხვა სტრინგი  */

    fun convertLessThanOneThousand(number: Int): String {
        if (number == 0) print("*** ნული")
        val hundreds = number / 100
        val units = number % 100
        val lessThanHundreds = convertZeroToHundred(units)
        return when (hundreds) {
            0 -> lessThanHundreds
            1 -> if (units > 0) {
                "ას$lessThanHundreds"
            } else {
                "ასი"
            }
            else -> if (units > 0) {
                ones2[hundreds] + "ას" + lessThanHundreds
            } else {
                ones2[hundreds] + "ასი"
            }
        }
    }

}