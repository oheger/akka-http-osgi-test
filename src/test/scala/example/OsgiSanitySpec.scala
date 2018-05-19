package example

import java.io.File

import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.ops4j.pax.exam.CoreOptions._
import org.ops4j.pax.exam.junit.PaxExam
import org.ops4j.pax.exam.{Configuration, Option => PaxOption}
import org.scalatest.junit.JUnitSuite

object OsgiSanitySpec {
  /** The directory with the bundles to be deployed. */
  val BundlesDir = new File("target/dependencies")

  /**
    * Returns an array with options for the bundles to be deployed in the
    * test OSGi container.
    *
    * @return an array with bundle options
    */
  def bundlesOption(): Array[PaxOption] =
    BundlesDir.listFiles().map(f => bundle(f.toURI.toString))
}

/**
  * PaxExam test class to check whether akka-http and all of its dependencies
  * are functional in an OSGi environment.
  */
@RunWith(classOf[PaxExam])
class OsgiSanitySpec extends JUnitSuite {

  import OsgiSanitySpec._

  @Configuration
  def config(): Array[PaxOption] =
    Array(junitBundles(), composite(bundlesOption(): _*))

  @Test def test(): Unit = {
    assertTrue("Successful", true)
  }
}
