package com.verimed.backend.blockchain;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.7.0.
 */
@SuppressWarnings("rawtypes")
public class ProductNFT extends Contract {
    public static final String BINARY = "\"deployedBytecode\": \"0x608060405234801561001057600080fd5b50600436106101165760003560e01c806375794a3c116100a2578063a22cb46511610071578063a22cb465146102cd578063b88d4fde146102e9578063c87b56dd14610305578063e985e9c514610335578063f2fde38b1461036557610116565b806375794a3c14610257578063775cb510146102755780638da5cb5b1461029157806395d89b41146102af57610116565b806323b872dd116100e957806323b872dd146101b557806342842e0e146101d15780636352211e146101ed57806370a082311461021d578063715018a61461024d57610116565b806301ffc9a71461011b57806306fdde031461014b578063081812fc14610169578063095ea7b314610199575b600080fd5b61013560048036038101906101309190611aeb565b610381565b6040516101429190611b33565b60405180910390f35b6101536103e2565b6040516101609190611bde565b60405180910390f35b610183600480360381019061017e9190611c36565b610474565b6040516101909190611ca4565b60405180910390f35b6101b360048036038101906101ae9190611ceb565b610490565b005b6101cf60048036038101906101ca9190611d2b565b6104a6565b005b6101eb60048036038101906101e69190611d2b565b6105a8565b005b61020760048036038101906102029190611c36565b6105c8565b6040516102149190611ca4565b60405180910390f35b61023760048036038101906102329190611d7e565b6105da565b6040516102449190611dba565b60405180910390f35b610255610694565b005b61025f6106a8565b60405161026c9190611dba565b60405180910390f35b61028f600480360381019061028a9190611f0a565b6106ae565b005b6102996106ea565b6040516102a69190611ca4565b60405180910390f35b6102b7610714565b6040516102c49190611bde565b60405180910390f35b6102e760048036038101906102e29190611f92565b6107a6565b005b61030360048036038101906102fe9190612073565b6107bc565b005b61031f600480360381019061031a9190611c36565b6107e1565b60405161032c9190611bde565b60405180910390f35b61034f600480360381019061034a91906120f6565b6108f4565b60405161035c9190611b33565b60405180910390f35b61037f600480360381019061037a9190611d7e565b610988565b005b6000634906490660e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614806103db57506103da82610a0e565b5b9050919050565b6060600080546103f190612165565b80601f016020809104026020016040519081016040528092919081815260200182805461041d90612165565b801561046a5780601f1061043f5761010080835404028352916020019161046a565b820191906000526020600020905b81548152906001019060200180831161044d57829003601f168201915b5050505050905090565b600061047f82610af0565b5061048982610b78565b9050919050565b6104a2828261049d610bb5565b610bbd565b5050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16036105185760006040517f64a0ae9200000000000000000000000000000000000000000000000000000000815260040161050f9190611ca4565b60405180910390fd5b600061052c8383610527610bb5565b610bcf565b90508373ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146105a2578382826040517f64283d7b00000000000000000000000000000000000000000000000000000000815260040161059993929190612196565b60405180910390fd5b50505050565b6105c3838383604051806020016040528060008152506107bc565b505050565b60006105d382610af0565b9050919050565b60008073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff160361064d5760006040517f89c62b640000000000000000000000000000000000000000000000000000000081526004016106449190611ca4565b60405180910390fd5b600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b61069c610de9565b6106a66000610e70565b565b60085481565b6106b6610de9565b6106c282600854610f36565b6106ce60085482610f54565b600860008154809291906106e1906121fc565b91905055505050565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b60606001805461072390612165565b80601f016020809104026020016040519081016040528092919081815260200182805461074f90612165565b801561079c5780601f106107715761010080835404028352916020019161079c565b820191906000526020600020905b81548152906001019060200180831161077f57829003601f168201915b5050505050905090565b6107b86107b1610bb5565b8383610fb0565b5050565b6107c78484846104a6565b6107db6107d2610bb5565b8585858561111f565b50505050565b60606107ec82610af0565b50600060066000848152602001908152602001600020805461080d90612165565b80601f016020809104026020016040519081016040528092919081815260200182805461083990612165565b80156108865780601f1061085b57610100808354040283529160200191610886565b820191906000526020600020905b81548152906001019060200180831161086957829003601f168201915b5050505050905060006108976112d0565b905060008151036108ac5781925050506108ef565b6000825111156108e15780826040516020016108c9929190612280565b604051602081830303815290604052925050506108ef565b6108ea846112e7565b925050505b919050565b6000600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b610990610de9565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1603610a025760006040517f1e4fbdf70000000000000000000000000000000000000000000000000000000081526004016109f99190611ca4565b60405180910390fd5b610a0b81610e70565b50565b60007f80ac58cd000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161480610ad957507f5b5e139f000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b80610ae95750610ae882611350565b5b9050919050565b600080610afc836113ba565b9050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1603610b6f57826040517f7e273289000000000000000000000000000000000000000000000000000000008152600401610b669190611dba565b60405180910390fd5b80915050919050565b60006004600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b600033905090565b610bca83838360016113f7565b505050565b600080610bdb846113ba565b9050600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614610c1d57610c1c8184866115bc565b5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610cae57610c5f6000856000806113f7565b6001600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825403925050819055505b600073ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff1614610d31576001600360008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825401925050819055505b846002600086815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550838573ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a4809150509392505050565b610df1610bb5565b73ffffffffffffffffffffffffffffffffffffffff16610e0f6106ea565b73ffffffffffffffffffffffffffffffffffffffff1614610e6e57610e32610bb5565b6040517f118cdaa7000000000000000000000000000000000000000000000000000000008152600401610e659190611ca4565b60405180910390fd5b565b6000600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905081600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a35050565b610f50828260405180602001604052806000815250611680565b5050565b80600660008481526020019081526020016000209081610f749190612450565b507ff8e1a15aba9398e019f0b49df1a4fde98ee17ae345cb5f6b5e2c27f5033e8ce782604051610fa49190611dba565b60405180910390a15050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff160361102157816040517f5b08ba180000000000000000000000000000000000000000000000000000000081526004016110189190611ca4565b60405180910390fd5b80600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31836040516111129190611b33565b60405180910390a3505050565b60008373ffffffffffffffffffffffffffffffffffffffff163b11156112c9578273ffffffffffffffffffffffffffffffffffffffff1663150b7a02868685856040518563ffffffff1660e01b815260040161117e9493929190612577565b6020604051808303816000875af19250505080156111ba57506040513d601f19601f820116820180604052508101906111b791906125d8565b60015b61123e573d80600081146111ea576040519150601f19603f3d011682016040523d82523d6000602084013e6111ef565b606091505b50600081510361123657836040517f64a0ae9200000000000000000000000000000000000000000000000000000000815260040161122d9190611ca4565b60405180910390fd5b805181602001fd5b63150b7a0260e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916817bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916146112c757836040517f64a0ae920000000000000000000000000000000000000000000000000000000081526004016112be9190611ca4565b60405180910390fd5b505b5050505050565b606060405180602001604052806000815250905090565b60606112f282610af0565b5060006112fd6112d0565b9050600081511161131d5760405180602001604052806000815250611348565b80611327846116a4565b604051602001611338929190612280565b6040516020818303038152906040525b915050919050565b60007f01ffc9a7000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916149050919050565b60006002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b80806114305750600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614155b1561156457600061144084610af0565b9050600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16141580156114ab57508273ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614155b80156114be57506114bc81846108f4565b155b1561150057826040517fa9fbf51f0000000000000000000000000000000000000000000000000000000081526004016114f79190611ca4565b60405180910390fd5b811561156257838573ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45b505b836004600085815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050565b6115c7838383611772565b61167b57600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff160361163c57806040517f7e2732890000000000000000000000000000000000000000000000000000000081526004016116339190611dba565b60405180910390fd5b81816040517f177e802f000000000000000000000000000000000000000000000000000000008152600401611672929190612605565b60405180910390fd5b505050565b61168a8383611833565b61169f611695610bb5565b600085858561111f565b505050565b6060600060016116b38461192c565b01905060008167ffffffffffffffff8111156116d2576116d1611ddf565b5b6040519080825280601f01601f1916602001820160405280156117045781602001600182028036833780820191505090505b509050600082602001820190505b600115611767578080600190039150507f3031323334353637383961626364656600000000000000000000000000000000600a86061a8153600a858161175b5761175a61262e565b5b04945060008503611712575b819350505050919050565b60008073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415801561182a57508273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff1614806117eb57506117ea84846108f4565b5b8061182957508273ffffffffffffffffffffffffffffffffffffffff1661181183610b78565b73ffffffffffffffffffffffffffffffffffffffff16145b5b90509392505050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16036118a55760006040517f64a0ae9200000000000000000000000000000000000000000000000000000000815260040161189c9190611ca4565b60405180910390fd5b60006118b383836000610bcf565b9050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146119275760006040517f73c6ac6e00000000000000000000000000000000000000000000000000000000815260040161191e9190611ca4565b60405180910390fd5b505050565b600080600090507a184f03e93ff9f4daa797ed6e38ed64bf6a1f010000000000000000831061198a577a184f03e93ff9f4daa797ed6e38ed64bf6a1f01000000000000000083816119805761197f61262e565b5b0492506040810190505b6d04ee2d6d415b85acef810000000083106119c7576d04ee2d6d415b85acef810000000083816119bd576119bc61262e565b5b0492506020810190505b662386f26fc1000083106119f657662386f26fc1000083816119ec576119eb61262e565b5b0492506010810190505b6305f5e1008310611a1f576305f5e1008381611a1557611a1461262e565b5b0492506008810190505b6127108310611a44576127108381611a3a57611a3961262e565b5b0492506004810190505b60648310611a675760648381611a5d57611a5c61262e565b5b0492506002810190505b600a8310611a76576001810190505b80915050919050565b6000604051905090565b600080fd5b600080fd5b60007fffffffff0000000000000000000000000000000000000000000000000000000082169050919050565b611ac881611a93565b8114611ad357600080fd5b50565b600081359050611ae581611abf565b92915050565b600060208284031215611b0157611b00611a89565b5b6000611b0f84828501611ad6565b91505092915050565b60008115159050919050565b611b2d81611b18565b82525050565b6000602082019050611b486000830184611b24565b92915050565b600081519050919050565b600082825260208201905092915050565b60005b83811015611b88578082015181840152602081019050611b6d565b60008484015250505050565b6000601f19601f8301169050919050565b6000611bb082611b4e565b611bba8185611b59565b9350611bca818560208601611b6a565b611bd381611b94565b840191505092915050565b60006020820190508181036000830152611bf88184611ba5565b905092915050565b6000819050919050565b611c1381611c00565b8114611c1e57600080fd5b50565b600081359050611c3081611c0a565b92915050565b600060208284031215611c4c57611c4b611a89565b5b6000611c5a84828501611c21565b91505092915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000611c8e82611c63565b9050919050565b611c9e81611c83565b82525050565b6000602082019050611cb96000830184611c95565b92915050565b611cc881611c83565b8114611cd357600080fd5b50565b600081359050611ce581611cbf565b92915050565b60008060408385031215611d0257611d01611a89565b5b6000611d1085828601611cd6565b9250506020611d2185828601611c21565b9150509250929050565b600080600060608486031215611d4457611d43611a89565b5b6000611d5286828701611cd6565b9350506020611d6386828701611cd6565b9250506040611d7486828701611c21565b9150509250925092565b600060208284031215611d9457611d93611a89565b5b6000611da284828501611cd6565b91505092915050565b611db481611c00565b82525050565b6000602082019050611dcf6000830184611dab565b92915050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b611e1782611b94565b810181811067ffffffffffffffff82111715611e3657611e35611ddf565b5b80604052505050565b6000611e49611a7f565b9050611e558282611e0e565b919050565b600067ffffffffffffffff821115611e7557611e74611ddf565b5b611e7e82611b94565b9050602081019050919050565b82818337600083830152505050565b6000611ead611ea884611e5a565b611e3f565b905082815260208101848484011115611ec957611ec8611dda565b5b611ed4848285611e8b565b509392505050565b600082601f830112611ef157611ef0611dd5565b5b8135611f01848260208601611e9a565b91505092915050565b60008060408385031215611f2157611f20611a89565b5b6000611f2f85828601611cd6565b925050602083013567ffffffffffffffff811115611f5057611f4f611a8e565b5b611f5c85828601611edc565b9150509250929050565b611f6f81611b18565b8114611f7a57600080fd5b50565b600081359050611f8c81611f66565b92915050565b60008060408385031215611fa957611fa8611a89565b5b6000611fb785828601611cd6565b9250506020611fc885828601611f7d565b9150509250929050565b600067ffffffffffffffff821115611fed57611fec611ddf565b5b611ff682611b94565b9050602081019050919050565b600061201661201184611fd2565b611e3f565b90508281526020810184848401111561203257612031611dda565b5b61203d848285611e8b565b509392505050565b600082601f83011261205a57612059611dd5565b5b813561206a848260208601612003565b91505092915050565b6000806000806080858703121561208d5761208c611a89565b5b600061209b87828801611cd6565b94505060206120ac87828801611cd6565b93505060406120bd87828801611c21565b925050606085013567ffffffffffffffff8111156120de576120dd611a8e565b5b6120ea87828801612045565b91505092959194509250565b6000806040838503121561210d5761210c611a89565b5b600061211b85828601611cd6565b925050602061212c85828601611cd6565b9150509250929050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061217d57607f821691505b6020821081036121905761218f612136565b5b50919050565b60006060820190506121ab6000830186611c95565b6121b86020830185611dab565b6121c56040830184611c95565b949350505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061220782611c00565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203612239576122386121cd565b5b600182019050919050565b600081905092915050565b600061225a82611b4e565b6122648185612244565b9350612274818560208601611b6a565b80840191505092915050565b600061228c828561224f565b9150612298828461224f565b91508190509392505050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b6000600883026123067fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826122c9565b61231086836122c9565b95508019841693508086168417925050509392505050565b6000819050919050565b600061234d61234861234384611c00565b612328565b611c00565b9050919050565b6000819050919050565b61236783612332565b61237b61237382612354565b8484546122d6565b825550505050565b600090565b612390612383565b61239b81848461235e565b505050565b5b818110156123bf576123b4600082612388565b6001810190506123a1565b5050565b601f821115612404576123d5816122a4565b6123de846122b9565b810160208510156123ed578190505b6124016123f9856122b9565b8301826123a0565b50505b505050565b600082821c905092915050565b600061242760001984600802612409565b1980831691505092915050565b60006124408383612416565b9150826002028217905092915050565b61245982611b4e565b67ffffffffffffffff81111561247257612471611ddf565b5b61247c8254612165565b6124878282856123c3565b600060209050601f8311600181146124ba57600084156124a8578287015190505b6124b28582612434565b86555061251a565b601f1984166124c8866122a4565b60005b828110156124f0578489015182556001820191506020850194506020810190506124cb565b8683101561250d5784890151612509601f891682612416565b8355505b6001600288020188555050505b505050505050565b600081519050919050565b600082825260208201905092915050565b600061254982612522565b612553818561252d565b9350612563818560208601611b6a565b61256c81611b94565b840191505092915050565b600060808201905061258c6000830187611c95565b6125996020830186611c95565b6125a66040830185611dab565b81810360608301526125b8818461253e565b905095945050505050565b6000815190506125d281611abf565b92915050565b6000602082840312156125ee576125ed611a89565b5b60006125fc848285016125c3565b91505092915050565b600060408201905061261a6000830185611c95565b6126276020830184611dab565b9392505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fdfea264697066735822122025ea92a8c248d646f5bdbc049d806ea6959941741740c4105439023ca9d9820d64736f6c634300081c0033\",";

    private static String librariesLinkedBinary;

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_MINTPRODUCTNFT = "mintProductNFT";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_NEXTTOKENID = "nextTokenId";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_safeTransferFrom = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final CustomError ERC721INCORRECTOWNER_ERROR = new CustomError("ERC721IncorrectOwner", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC721INSUFFICIENTAPPROVAL_ERROR = new CustomError("ERC721InsufficientApproval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final CustomError ERC721INVALIDAPPROVER_ERROR = new CustomError("ERC721InvalidApprover", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC721INVALIDOPERATOR_ERROR = new CustomError("ERC721InvalidOperator", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC721INVALIDOWNER_ERROR = new CustomError("ERC721InvalidOwner", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC721INVALIDRECEIVER_ERROR = new CustomError("ERC721InvalidReceiver", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC721INVALIDSENDER_ERROR = new CustomError("ERC721InvalidSender", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError ERC721NONEXISTENTTOKEN_ERROR = new CustomError("ERC721NonexistentToken", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final CustomError OWNABLEINVALIDOWNER_ERROR = new CustomError("OwnableInvalidOwner", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final CustomError OWNABLEUNAUTHORIZEDACCOUNT_ERROR = new CustomError("OwnableUnauthorizedAccount", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event BATCHMETADATAUPDATE_EVENT = new Event("BatchMetadataUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event METADATAUPDATE_EVENT = new Event("MetadataUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected ProductNFT(String contractAddress, Web3j web3j, Credentials credentials,
                         BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProductNFT(String contractAddress, Web3j web3j, Credentials credentials,
                         ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProductNFT(String contractAddress, Web3j web3j, TransactionManager transactionManager,
                         BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProductNFT(String contractAddress, Web3j web3j, TransactionManager transactionManager,
                         ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ApprovalEventResponse> getApprovalEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ApprovalEventResponse getApprovalEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVAL_EVENT, log);
        ApprovalEventResponse typedResponse = new ApprovalEventResponse();
        typedResponse.log = log;
        typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getApprovalEventFromLog(log));
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public static List<ApprovalForAllEventResponse> getApprovalForAllEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ApprovalForAllEventResponse getApprovalForAllEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, log);
        ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
        typedResponse.log = log;
        typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getApprovalForAllEventFromLog(log));
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    public static List<BatchMetadataUpdateEventResponse> getBatchMetadataUpdateEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BATCHMETADATAUPDATE_EVENT, transactionReceipt);
        ArrayList<BatchMetadataUpdateEventResponse> responses = new ArrayList<BatchMetadataUpdateEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            BatchMetadataUpdateEventResponse typedResponse = new BatchMetadataUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._fromTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._toTokenId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static BatchMetadataUpdateEventResponse getBatchMetadataUpdateEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(BATCHMETADATAUPDATE_EVENT, log);
        BatchMetadataUpdateEventResponse typedResponse = new BatchMetadataUpdateEventResponse();
        typedResponse.log = log;
        typedResponse._fromTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse._toTokenId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<BatchMetadataUpdateEventResponse> batchMetadataUpdateEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getBatchMetadataUpdateEventFromLog(log));
    }

    public Flowable<BatchMetadataUpdateEventResponse> batchMetadataUpdateEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BATCHMETADATAUPDATE_EVENT));
        return batchMetadataUpdateEventFlowable(filter);
    }

    public static List<MetadataUpdateEventResponse> getMetadataUpdateEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(METADATAUPDATE_EVENT, transactionReceipt);
        ArrayList<MetadataUpdateEventResponse> responses = new ArrayList<MetadataUpdateEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MetadataUpdateEventResponse typedResponse = new MetadataUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static MetadataUpdateEventResponse getMetadataUpdateEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(METADATAUPDATE_EVENT, log);
        MetadataUpdateEventResponse typedResponse = new MetadataUpdateEventResponse();
        typedResponse.log = log;
        typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<MetadataUpdateEventResponse> metadataUpdateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getMetadataUpdateEventFromLog(log));
    }

    public Flowable<MetadataUpdateEventResponse> metadataUpdateEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(METADATAUPDATE_EVENT));
        return metadataUpdateEventFlowable(filter);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static OwnershipTransferredEventResponse getOwnershipTransferredEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
        OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
        typedResponse.log = log;
        typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getOwnershipTransferredEventFromLog(log));
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public static List<TransferEventResponse> getTransferEvents(
            TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static TransferEventResponse getTransferEventFromLog(Log log) {
        EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSFER_EVENT, log);
        TransferEventResponse typedResponse = new TransferEventResponse();
        typedResponse.log = log;
        typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getTransferEventFromLog(log));
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new Address(160, to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
        final Function function = new Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
        final Function function = new Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new Address(160, owner),
                new Address(160, operator)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mintProductNFT(String to, String tokenURI) {
        final Function function = new Function(
                FUNC_MINTPRODUCTNFT, 
                Arrays.<Type>asList(new Address(160, to),
                new Utf8String(tokenURI)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> nextTokenId() {
        final Function function = new Function(FUNC_NEXTTOKENID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ownerOf(BigInteger tokenId) {
        final Function function = new Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to,
            BigInteger tokenId) {
        final Function function = new Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new Address(160, from),
                new Address(160, to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to,
            BigInteger tokenId, byte[] data) {
        final Function function = new Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new Address(160, from),
                new Address(160, to),
                new Uint256(tokenId),
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String operator,
            Boolean approved) {
        final Function function = new Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new Address(160, operator),
                new Bool(approved)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenURI(BigInteger tokenId) {
        final Function function = new Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to,
            BigInteger tokenId) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(160, from),
                new Address(160, to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new Address(160, newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ProductNFT load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductNFT(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProductNFT load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductNFT(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProductNFT load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new ProductNFT(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProductNFT load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProductNFT(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ProductNFT> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String initialOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, initialOwner)));
        return deployRemoteCall(ProductNFT.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<ProductNFT> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, String initialOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, initialOwner)));
        return deployRemoteCall(ProductNFT.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProductNFT> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String initialOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, initialOwner)));
        return deployRemoteCall(ProductNFT.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProductNFT> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, String initialOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, initialOwner)));
        return deployRemoteCall(ProductNFT.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }

    public static class BatchMetadataUpdateEventResponse extends BaseEventResponse {
        public BigInteger _fromTokenId;

        public BigInteger _toTokenId;
    }

    public static class MetadataUpdateEventResponse extends BaseEventResponse {
        public BigInteger _tokenId;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }
}
