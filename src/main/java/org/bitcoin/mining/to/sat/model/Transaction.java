package org.bitcoin.mining.to.sat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// This is just an example Transaction class, inputs should be models with scriptSig, index, and other fields, outputs
// and witnesses should look different too.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int txInCount;
    private List<String> inputs;
    private int txOutCount;
    private List<String> outputs;
    private List<String> witnesses;
    private long lockTime;
}
