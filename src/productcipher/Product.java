/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher;

/**
 *
 * @author Dilantha
 */
public class Product {
    private final Substitution substitution;
    private final Permutation permutation;

    public Product() {
        this.substitution = new Substitution();
        this.permutation = new Permutation();
    }

    public String encrypt(String plain, String key) {
        return permutation.encrypt(substitution.encrypt(plain, key), key);
    }

    public String decrypt(String plain, String key) {
        return substitution.decrypt(permutation.decrypt(plain, key), key);
    }
}
