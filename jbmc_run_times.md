# 1. Run on the simplest possible solution (When everything is inside Main)

Runtime Symex: 0.129058s <br>
size of program expression: 3301 steps <br>
simple slicing removed 79 assignments <br>
Generated 145 VCC(s), 1 remaining after simplification <br>
Runtime Postprocess Equation: 0.0009088s <br>
Passing problem to string refinement loop with MiniSAT 2.2.1 without simplifier <br>
converting SSA <br>
Runtime Convert SSA: 0.0101675s <br>
Running string refinement loop with MiniSAT 2.2.1 without simplifier<br>
BV-Refinement: post-processing<br>
BV-Refinement: iteration 1<br>
46456 variables, 50745 clauses<br>
SAT checker: instance is SATISFIABLE<br>
BV-Refinement: got SAT, and it simulates => SAT<br>
Total iterations: 1<br>
Runtime Solver: 0.0532662s<br>
Runtime decision procedure: 0.0643802s<br>
Building error trace<br>

CONSUMED RAM: 7-10 GB<br>
ELAPSED TIME: 4-10 minutes<br>
JBMC PARAMS: jbmc org.bitcoin.mining.to.sat.Main --disable-uncaught-exception-check --java-assume-inputs-non-null --unwind 5

# 2. Run on the simplest possible solution (When everything is inside Main)

Passing problem to string refinement loop with MiniSAT 2.2.1 without simplifier <br>
converting SSA <br>
Runtime Convert SSA: 0.0106291s<br>
Running string refinement loop with MiniSAT 2.2.1 without simplifier<br>
BV-Refinement: post-processing<br>
BV-Refinement: iteration 1<br>
46456 variables, 50745 clauses<br>
SAT checker: instance is SATISFIABLE<br>
BV-Refinement: got SAT, and it simulates => SAT<br>
Total iterations: 1<br>
Runtime Solver: 0.0545347s<br>
Runtime decision procedure: 0.0661183s<br>
Building error trace<br>
Counterexample:

CONSUMED RAM: 20+ GB <br>
ELAPSED TIME: <br>
JBMC PARAMS: jbmc org.bitcoin.mining.to.sat.Main --disable-uncaught-exception-check --java-assume-inputs-non-null --unwind 5 --stop-on-fail

# 3. GOOD RUN ON THIS PROGRAM:

    public static void main(String[] args) {
    final Block block = BlockData.getBlock100500ThExample();

            long nonce = 510;
            int flag = 0;

            block.getHeader().setNonce(nonce);

            final String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

            // Here we check if the hash is valid
            if (Objects.nonNull(sha256hex)) {
                flag = 1;
            }

            assert (flag == 0);
        }

Runtime Symex: 0.0327347s <br>
size of program expression: 1004 steps <br>
simple slicing removed 6 assignments<br>
Generated 27 VCC(s), 1 remaining after simplification<br>
Runtime Postprocess Equation: 0.0007907s<br>
Passing problem to string refinement loop with MiniSAT 2.2.1 without simplifier<br>
converting SSA<br>
Runtime Convert SSA: 0.0024571s<br>
Running string refinement loop with MiniSAT 2.2.1 without simplifier<br>
BV-Refinement: post-processing<br>
BV-Refinement: iteration 1<br>
9264 variables, 8399 clauses<br>
SAT checker: instance is SATISFIABLE<br>
BV-Refinement: got SAT, and it simulates => SAT<br>

RUNTIME: ~1 second<br>
CONSUMED RAM: ? (too fast to measure it, very little amount of ram is consumed)<br>
JBMC PARAMETERS: jbmc org.bitcoin.mining.to.sat.Main --trace<br>

# 4. IF I ADD JUST ONE LOOP TO MY PROGRAM, IT WILL RUN VERY LONG

    public static void main(String[] args) {
    final Block block = BlockData.getBlock100500ThExample();
    final String targetDifficulty = BlockUtil.convertBitsToTarget(block.getHeader().getBits()); **new loop**

        long nonce = 510;
        int flag = 0;

        block.getHeader().setNonce(nonce);

        final String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

        // Here we check if the hash is valid
        if (Objects.nonNull(sha256hex)) {
            flag = 1;
        }

        assert (flag == 0);
    }

Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 398 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 399 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 400 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 401 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 402 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 403 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 404 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 405 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 406 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 407 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 408 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 409 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 410 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 411 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 412 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 413 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 414 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 415 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 416 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 417 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 418 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 419 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 420 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 421 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 422 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 423 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0
Unwinding loop java::org.bitcoin.mining.to.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String;.0 iteration 424 file org/bitcoin/mining/to/sat/util/BlockUtil.java line 108 function java::org.bitcoin.mining.t
o.sat.util.BlockUtil.convertBitsToTarget:(Ljava/lang/String;)Ljava/lang/String; bytecode-index 46 thread 0

It goes too long with the unwinding of the loops so I stopped the program.

# 5. Run for loop with 10000 length

    public static void run1() {
        int x = 0;
        for(int i = 0; i < 10000; i++) {
            x++;
        }

        assert (x == 0);
    }

Passing problem to string refinement loop with MiniSAT 2.2.1 without simplifier <br>
converting SSA<br>
Runtime Convert SSA: 0.0791915s<br>
Running string refinement loop with MiniSAT 2.2.1 without simplifier<br>
BV-Refinement: post-processing<br>
BV-Refinement: iteration 1<br>
4984 variables, 5362 clauses<br>
SAT checker: instance is SATISFIABLE<br>
BV-Refinement: got SAT, and it simulates => SAT<br>
Total iterations: 1<br>
Runtime Solver: 0.0791763s<br>
Runtime decision procedure: 0.160063s<br>

RUNTIME: ~3 seconds<br>
CONSUMED RAM: ? (too fast to measure it, very little amount of ram is consumed)<br>
JBMC PARAMETERS: jbmc org.bitcoin.mining.to.sat.Main<br>

# 5. Run for loop with 100000 length

    public static void run1() {
        int x = 0;
        for(int i = 0; i < 100000; i++) {
            x++;
        }

        assert (x == 0);
    }

Runtime Symex: 28.6202s<br>
size of program expression: 400416 steps<br>
simple slicing removed 6 assignments<br>
Generated 4 VCC(s), 1 remaining after simplification<br>
Runtime Postprocess Equation: 0.0756711s<br>
Passing problem to string refinement loop with MiniSAT 2.2.1 without simplifier<br>
converting SSA<br>
Runtime Convert SSA: 0.829884s<br>
Running string refinement loop with MiniSAT 2.2.1 without simplifier<br>
BV-Refinement: post-processing<br>
BV-Refinement: iteration 1<br>
4984 variables, 5362 clauses<br>
SAT checker: instance is SATISFIABLE<br>
BV-Refinement: got SAT, and it simulates => SAT<br>

RUNTIME: ~20-30 seconds<br>
CONSUMED RAM: ~1GB (too fast to keep track of it, little amount of ram is consumed)<br>
JBMC PARAMETERS: jbmc org.bitcoin.mining.to.sat.Main<br>

### HERE IT IS VERY IMPORTANT THAT SIZE OF LOOP ITERATIONS DOESN'T INSCREASE CLAUSES AND VARIABLES

### If --unwind 5 is set, this is the run:

PS C:\Users\tothz\Desktop\DIPLOMAMUNKA\bitcoin-miner-java\target\classes> jbmc org.bitcoin.mining.to.sat.Main --unwind 5
\*\*\*\* WARNING: Use --unwinding-assertions to obtain sound verification results
JBMC version 5.93.0 (cbmc-5.93.0) 64-bit x86_64 windows  
Parsing ...  
Trying to load Java main class: org.bitcoin.mining.to.sat.Main  
Found Java main class: org.bitcoin.mining.to.sat.Main  
Converting  
stub class symbol java::java.lang.Object already exists
Java: added 50 String or Class constant symbols  
Generating GOTO Program  
Running GOTO functions transformation passes  
Running with 16 object bits, 48 offset bits (default)  
Starting Bounded Model Checking  
Unwinding loop **CPROVER**start.0 iteration 1 thread 0
Unwinding loop **CPROVER**start.0 iteration 2 thread 0
Unwinding loop **CPROVER**start.0 iteration 3 thread 0  
Unwinding loop **CPROVER**start.0 iteration 4 thread 0  
Not unwinding loop **CPROVER**start.0 iteration 5 thread 0  
Unwinding recursion java::org.bitcoin.mining.to.sat.Main.<clinit_wrapper> iteration 1  
Unwinding loop java::org.bitcoin.mining.to.sat.Main.run1:()V.0 iteration 1 file org/bitcoin/mining/to/sat/Main.java line 37 function java::org.bitcoin.mining.to.sat.Main.run1:()V bytecode-index 9 thread 0  
Unwinding loop java::org.bitcoin.mining.to.sat.Main.run1:()V.0 iteration 2 file org/bitcoin/mining/to/sat/Main.java line 37 function java::org.bitcoin.mining.to.sat.Main.run1:()V bytecode-index 9 thread 0  
Unwinding loop java::org.bitcoin.mining.to.sat.Main.run1:()V.0 iteration 3 file org/bitcoin/mining/to/sat/Main.java line 37 function java::org.bitcoin.mining.to.sat.Main.run1:()V bytecode-index 9 thread 0  
Unwinding loop java::org.bitcoin.mining.to.sat.Main.run1:()V.0 iteration 4 file org/bitcoin/mining/to/sat/Main.java line 37 function java::org.bitcoin.mining.to.sat.Main.run1:()V bytecode-index 9 thread 0  
Not unwinding loop java::org.bitcoin.mining.to.sat.Main.run1:()V.0 iteration 5 file org/bitcoin/mining/to/sat/Main.java line 37 function java::org.bitcoin.mining.to.sat.Main.run1:()V bytecode-index 9 thread 0
aborting path on assume(false) at file org/bitcoin/mining/to/sat/Main.java line 41 function java::org.bitcoin.mining.to.sat.Main.run1:()V bytecode-index 17 thread 0  
Runtime Symex: 0.0141816s  
size of program expression: 381 steps  
simple slicing removed 0 assignments
Generated 1 VCC(s), 0 remaining after simplification
Runtime Postprocess Equation: 0.0005165s

\*\* Results:
[array-create-negative-size.1] Array size should be >= 0: SUCCESS
[array-create-negative-size.2] Array size should be >= 0: SUCCESS
[array-create-negative-size.3] Array size should be >= 0: SUCCESS
[array-create-negative-size.4] Array size should be >= 0: SUCCESS
[array-create-negative-size.5] Array size should be >= 0: SUCCESS
[array-create-negative-size.6] Array size should be >= 0: SUCCESS
[array-create-negative-size.7] Array size should be >= 0: SUCCESS
[array-create-negative-size.8] Array size should be >= 0: SUCCESS
[array-create-negative-size.9] Array size should be >= 0: SUCCESS
org/bitcoin/mining/to/sat/Main.java function java::org.bitcoin.mining.to.sat.Main.<clinit>:()V
[java::org.bitcoin.mining.to.sat.Main.<clinit>:()V.null-pointer-exception.1] line 10 Null pointer check: SUCCESS

org/bitcoin/mining/to/sat/Main.java function java::org.bitcoin.mining.to.sat.Main.main:([Ljava/lang/String;)V
[java::org.bitcoin.mining.to.sat.Main.main:([Ljava/lang/String;)V.1] line 13 no uncaught exception: SUCCESS

org/bitcoin/mining/to/sat/Main.java function java::org.bitcoin.mining.to.sat.Main.run1:()V
[java::org.bitcoin.mining.to.sat.Main.run1:()V.assertion.1] line 41 assertion at file org/bitcoin/mining/to/sat/Main.java line 41 function java::org.bitcoin.mining.to.sat.Main.run1:()V bytecode-index 17: SUCCESS
[java::org.bitcoin.mining.to.sat.Main.run1:()V.null-pointer-exception.1] line 41 Null pointer check: SUCCESS

\*\* 0 of 13 failed (1 iterations)
VERIFICATION SUCCESSFUL

### This means the loop didn't finish because it run only 5 times, so the assertion fail is not found.

### If this for loop is changed to a while loop, it will have a very similar run

# 6. A run that takes too much time

### The following program takes so much time, that i stopped it. It would take i think 10-50 mins to finish run. Iterations run very slowly.

    public static void run2() {
        int x = 0;
        int y = 10;
        y++;
        x += y;
        String s = "";
        while(x < 100000) {
            x++;
            s += String.valueOf(x);
        }
        int z = x + y;
        if(x == 500) {
            x = 2;
        }

        assert (x == 0);
    }

### If we remove the s += String.valueOf(x); from the while loop, it will be as fast as the examples before. So, inside loops, any code can increase the runtime dramatically.

### If we run the program with the string concatenation in it, at unwind 1000 it will have 50k steps, but on unwind 10000 it will have 500k steps. So on the default 100000 unwind, it would have around 5 million steps!!

### If we add another string concatenation inside the loop, it will have at 1000 unwind around 100k steps. So every new operation we do will DOUBLE the number of steps!!!

# 7. Another good run

### This program gives a good nonce. But the while loop will instantly break because the initial nonce is set to 510.

    public static void main(String[] args) {
        final Block block = BlockData.getBlock100500ThExample();

        long nonce = 509;
        while(nonce < 600) {
            int flag = 0;
            nonce++;

            block.getHeader().setNonce(nonce);

            final String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

            // Here we check if the hash is valid
            if (Objects.nonNull(sha256hex)) {
                flag = 1;
            }

            assert (flag == 0);
        }
    }

### It also runs very fast, finished in less than 1 second.

# 8. Changing the check to startsWith doesn't affect it much. Still will be good.

    public static void main(String[] args) {
        final Block block = BlockData.getBlock100500ThExample();

        long nonce = 509;
        while (nonce < 600) {
            int flag = 0;
            nonce++;

            block.getHeader().setNonce(nonce);

            final String sha256hex = DigestUtils.sha256Hex(DigestUtils.sha256Hex(block.getHeader().toString()));

            // Here we check if the hash is valid
            if (sha256hex.startsWith("00")) {
                flag = 1;
            }

            assert (flag == 0);
        }
    }

# 9.
