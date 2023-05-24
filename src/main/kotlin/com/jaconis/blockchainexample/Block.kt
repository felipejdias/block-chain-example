package com.jaconis.blockchainexample

import com.google.gson.GsonBuilder
import java.math.BigInteger
import java.security.MessageDigest

data class Block(var index: Int,
                 var timestamp: Long,
                 var data: String,
                 var previousHash: String = "",
                 var nonce: Int = 0
                 ) {
    var hash: String = calculateHash()


    override fun toString(): String {
        var jsonString = "{\"index\" : \"$index\", \"timestamp\" : \"$timestamp\", \"data\" : \"$data\", \"previousHash\" : \"$previousHash\", \"hash\" : \"$hash\"}"
        val gson = GsonBuilder().setPrettyPrinting().create()
        val block = gson.fromJson(jsonString, Block::class.java)
        return gson.toJson(block)
    }


}
fun Block.calculateHash(): String {
    val md = MessageDigest.getInstance("SHA-256")
    val input = "${this.index}${this.previousHash}${this.timestamp}${this.data}${this.nonce}"
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}






