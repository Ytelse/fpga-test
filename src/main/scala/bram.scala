package Bram

import Chisel._


class BramLed extends Module {
  val io = new Bundle {
    val out = Bits(width = 4).asOutput
    val in = Bits(width = 4).asInput
  }
  io.out := io.in
}


object Top {
  def main(args: Array[String]) {
    chiselMainTest(args, () =>
        Module(new BramLed)) {
      bl => new Tester(bl)
    }
  }
}
