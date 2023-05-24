package com.jaconis.blockchainexample

class Main

    fun main(args: Array<String>){
        var blockChain = BlockChain()
        blockChain.addBlock(Block(1, 12343534656, "{amount : 4}"))
        blockChain.addBlock(Block(2, 12343534656, "{amount : 4}"))

        blockChain.chain.forEach {
            println(it.toString())
        }

        println("is my block chain valid: " + blockChain.isChainValid())

    }
