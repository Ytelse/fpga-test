package Bram

import Chisel._


class BramLed extends Module {
  val io = new Bundle {
    val out = Bits(width = 1).asOutput
  }
  io.out := UInt(1)
}


object Bram {
  def main(args: Array[String]) {
    val margs = Array("--backend", "v", "--genHarness")
    chiselMainTest(margs, () =>
        Module(new BramLed)) {
      bl => new Tester(bl)
    }
  }
}
