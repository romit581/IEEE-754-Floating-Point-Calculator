package com.ieee754;
public class IEEE754Calculator {
    
    // Result class to hold the calculation results
    public static class FloatResult {
        public int sign;
        public int exponent;
        public long mantissa;
        public String binary;
        public String hex;
        public int actualExponent;
        public int format; // 32 or 64
        
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
        
        @Override
        public String toString() {
            return String.format(
                "Format: %d-bit\nSign: %d (%s)\nExponent: %d (Actual: %d)\nMantissa: %s\nBinary: %s\nHex: %s",
                format,
                sign, 
                sign == 0 ? "Positive" : "Negative",
                exponent,
                actualExponent,
                Long.toHexString(mantissa).toUpperCase(),
                binary,
                hex
            );
        }
        
        // Convert to JSON string for API response
        public String toJSON() {
            return String.format(
                "{\"sign\":%d,\"exponent\":%d,\"mantissa\":\"%s\",\"binary\":\"%s\"," +
                "\"hex\":\"%s\",\"actualExponent\":%d,\"format\":%d,\"signText\":\"%s\"}",
                sign, exponent, Long.toHexString(mantissa).toUpperCase(), binary, hex, 
                actualExponent, format, sign == 0 ? "Positive" : "Negative"
            );
        }
    }
    
    /**
     * Convert a decimal number to IEEE 754 single precision (32-bit)
     */
    public static FloatResult convertToFloat32(float number) {
        int bits = Float.floatToIntBits(number);
        
        // Extract components
        int sign = (bits >>> 31) & 1;
        int exponent = (bits >>> 23) & 0xFF;
        int mantissa = bits & 0x7FFFFF;
        
        // Calculate actual exponent
        int bias = 127;
        int actualExponent = exponent - bias;
        
        // Build binary representation
        String signBit = Integer.toBinaryString(sign);
        String expBits = String.format("%8s", Integer.toBinaryString(exponent)).replace(' ', '0');
        String mantBits = String.format("%23s", Integer.toBinaryString(mantissa)).replace(' ', '0');
        String binary = signBit + expBits + mantBits;
        
        // Hexadecimal representation
        String hex = "0x" + String.format("%08X", bits);
        
        return new FloatResult(sign, exponent, mantissa, binary, hex, actualExponent, 32);
    }
    
    /**
     * Convert a decimal number to IEEE 754 double precision (64-bit)
     */
    public static FloatResult convertToFloat64(double number) {
        long bits = Double.doubleToLongBits(number);
        
        // Extract components
        int sign = (int)((bits >>> 63) & 1);
        int exponent = (int)((bits >>> 52) & 0x7FF);
        long mantissa = bits & 0xFFFFFFFFFFFFFL;
        
        // Calculate actual exponent
        int bias = 1023;
        int actualExponent = exponent - bias;
        
        // Build binary representation
        String signBit = Integer.toBinaryString(sign);
        String expBits = String.format("%11s", Integer.toBinaryString(exponent)).replace(' ', '0');
        String mantBits = String.format("%52s", Long.toBinaryString(mantissa)).replace(' ', '0');
        String binary = signBit + expBits + mantBits;
        
        // Hexadecimal representation
        String hex = "0x" + String.format("%016X", bits);
        
        return new FloatResult(sign, exponent, mantissa, binary, hex, actualExponent, 64);
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        // Test with some examples
        System.out.println("=== Testing Float32 (Single Precision) ===");
        FloatResult result32 = convertToFloat32(3.14159f);
        System.out.println(result32);
        System.out.println("\nJSON: " + result32.toJSON());
        
        System.out.println("\n=== Testing Float64 (Double Precision) ===");
        FloatResult result64 = convertToFloat64(3.14159265358979);
        System.out.println(result64);
        System.out.println("\nJSON: " + result64.toJSON());
        
        // Test negative number
        System.out.println("\n=== Testing Negative Number ===");
        FloatResult resultNeg = convertToFloat32(-42.5f);
        System.out.println(resultNeg);
        
        // Test special cases
        System.out.println("\n=== Testing Special Cases ===");
        System.out.println("Zero:");
        System.out.println(convertToFloat32(0.0f));
        
        System.out.println("\nInfinity:");
        System.out.println(convertToFloat32(Float.POSITIVE_INFINITY));
        
        System.out.println("\nNaN:");
        System.out.println(convertToFloat32(Float.NaN));
    }
}