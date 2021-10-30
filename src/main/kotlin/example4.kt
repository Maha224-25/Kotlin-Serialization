import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Student(val id: Int,val name: String )

@Serializable
data class Department(val name: String, val students: List<Student>)

fun main() {
  //    JSON encoding --- Serializable classes to json format
  val studs=listOf(Student(1,"Heike"),Student(2,"Marco"),Student(3,"Mauro"))

  val depart1=Department("IT web",studs)

  println("JSON encoding ...")
  println(Json.encodeToString(depart1))
  //-----------------------------------
  //      JSON decoding --- json format To Serializable classes
  val jsonText="""
{"name":"IT web","students":[{"id":1,"name":"Heike"},{"id":2,"name":"Marco"},{"id":3,"name":"Mauro"}]}	
    """
  val depart2=Json.decodeFromString<Department>(jsonText);

  println("JSON decoding ...")
  println(depart2)
  //------------------------------------
}