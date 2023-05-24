package com.jaconis.blockchainexample

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject

class BlockChain {

    var chain: Array<Block>

   constructor(){
       this.chain = arrayOf(this.createGenesisBlock())
   }


    private fun createGenesisBlock(): Block{
        return Block(0, 1684373371, "{Genesis Block}", "0")
    }

    fun getLatestBlock(): Block{
        return this.chain[chain.lastIndex]
    }

    fun addBlock(newBlock: Block){
        newBlock.previousHash = this.getLatestBlock().hash
        newBlock.hash = newBlock.calculateHash()
        this.chain = this.chain.plus(newBlock)
    }

    fun isChainValid(): Boolean{
        this.chain.forEach {
            if(it.index > 0) {
                var currentBlock = it
                var previousBlock = this.chain[it.index - 1]
                if (currentBlock.hash != currentBlock.calculateHash())
                    return false

                if (currentBlock.previousHash != previousBlock.hash)
                    return false
            }
        }

        return true
    }

    fun mineBlock(difi)
}