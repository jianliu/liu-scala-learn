package le.liu

/**
 * Created by IntelliJ IDEA.
 * User: liu
 * Date: 13-5-14
 * Time: 下午5:38
 *
 */

object FunctTest extends App {

  implicit def magic: String = "magic"

  def callMagic(f: => Unit)(implicit magic: String) {
    f
    println("callMagic " + magic)
    println("  --------- ")
  }

  def callMagic(f: String => Unit)(implicit magic: String) {
    f(magic)
    println("callMagicString " + magic)
    println("  --------- ")
  }

  callMagic {
    println("try call magic")
    println("have i call magic sucess?")
  }

  callMagic((s: String) => {
    println("aaaaaa")
  })

  callMagic {
    (abc) => {
      println(abc)
    }
  }
}