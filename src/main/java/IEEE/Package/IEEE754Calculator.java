package IEEE.Package;

public class IEEE754Calculator {

    public static class FloatResult {
        public int sign;
        public int exponent;
        public long mantissa;
        public String binary;
        public String hex;
        public int actualExponent;
        public int format;

        public FloatResult(int sign, int exponent, long mantissa, String binary,
                           String hex, int actualExponent, int format) {
            this.sign = sign;
            this.exponent = exponent;
            this.mantissa = mantissa;
            this.binary = binary;
            this.hex = hex;
            this.actualExponent = actualExponent;
            this.format = format;
        }
    }

    public static FloatResult convertToFloat32(float number) {
        int bits = Float.floatToIntBits(number);

        int sign = (bits >>> 31) & 1;
        int exponent = (bits >>> 23) & 0xFF;
        int mantissa = bits & 0x7FFFFF;
        int actualExponent = exponent - 127;

        String binary = Integer.toBinaryString(sign)
                + String.format("%8s", Integer.toBinaryString(exponent)).replace(' ', '0')
                + String.format("%23s", Integer.toBinaryString(mantissa)).replace(' ', '0');

        String hex = "0x" + String.format("%08X", bits);

        return new FloatResult(sign, exponent, mantissa, binary, hex, actualExponent, 32);
    }

    public static FloatResult convertToFloat64(double number) {
        long bits = Double.doubleToLongBits(number);

        int sign = (int) ((bits >>> 63) & 1);
        int exponent = (int) ((bits >>> 52) & 0x7FF);
        long mantissa = bits & 0xFFFFFFFFFFFFFL;
        int actualExponent = exponent - 1023;

        String binary = Integer.toBinaryString(sign)
                + String.format("%11s", Integer.toBinaryString(exponent)).replace(' ', '0')
                + String.format("%52s", Long.toBinaryString(mantissa)).replace(' ', '0');

        String hex = "0x" + String.format("%016X", bits);

        return new FloatResult(sign, exponent, mantissa, binary, hex, actualExponent, 64);
    }
}
