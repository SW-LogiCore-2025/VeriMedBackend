package com.verimed.backend.blockchain;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.DefaultGasProvider;

@Service
public class BlockchainService {
    private static final String CONTRACT_ADDRESS = "0x2CB33164A5cDf33D4380cd157Aa010C628999FCA";
    private static final String PRIVATE_KEY = "6a56eb5d8e931bcd597a15b8d0957d06d1170e940dfa2a0862faa6121fcc0c6f";
    private static final String ALCHEMY_URL = "https://eth-sepolia.g.alchemy.com/v2/cXhgKUcT4kq8Q9wUv4FiGGxTk0cSrlYM";

    private Web3j web3j;
    private Credentials credentials;
    private ProductNFT contract;

    public BlockchainService() {
        web3j = Web3j.build(new HttpService(ALCHEMY_URL));
        credentials = Credentials.create(PRIVATE_KEY);
        contract = ProductNFT.load(CONTRACT_ADDRESS, web3j, credentials, new DefaultGasProvider());
    }

    public void mintNFT(String recipient, String tokenURI) throws Exception {
        contract.mintProductNFT(recipient, tokenURI).send();
    }

    public String getContractName() throws Exception {
        return contract.name().send();
    }
}