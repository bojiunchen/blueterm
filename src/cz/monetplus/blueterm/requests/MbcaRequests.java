package cz.monetplus.blueterm.requests;

import cz.monetplus.blueterm.TransactionIn;
import cz.monetplus.blueterm.bprotocol.BProtocolMessages;
import cz.monetplus.blueterm.frames.SLIPFrame;
import cz.monetplus.blueterm.frames.TerminalFrame;
import cz.monetplus.blueterm.terminals.TerminalPortApplications;
import cz.monetplus.blueterm.worker.HandleMessage;
import cz.monetplus.blueterm.worker.HandleOperations;

public class MbcaRequests {
    /**
     * Create and send pay request to terminal.
     * @param transactionInputData 
     * @return 
     */
    public static HandleMessage pay(TransactionIn transactionInputData) {
        return (new HandleMessage(HandleOperations.TerminalWrite,
                SLIPFrame.createFrame(new TerminalFrame(
                        TerminalPortApplications.MBCA
                                .getPortApplicationNumber(), BProtocolMessages
                                .getSale(transactionInputData.getAmount(),
                                        transactionInputData.getCurrency(),
                                        transactionInputData.getInvoice()))
                        .createFrame())));
    }

    /**
     * Create and send handshake to terminal.
     */
    public static HandleMessage handshakeMbca() {
        return (new HandleMessage(HandleOperations.TerminalWrite,
                SLIPFrame.createFrame(new TerminalFrame(
                        TerminalPortApplications.MBCA
                                .getPortApplicationNumber(), BProtocolMessages
                                .getHanshake()).createFrame())));
    }

    /**
     * Create and send handshake to terminal.
     */
    public static HandleMessage balancingMbca(TransactionIn transactionInputData) {
        return (new HandleMessage(HandleOperations.TerminalWrite,
                SLIPFrame.createFrame(new TerminalFrame(
                        TerminalPortApplications.MBCA
                                .getPortApplicationNumber(), BProtocolMessages
                                .getBalancing(transactionInputData
                                        .getBalancing())).createFrame())));
    }

     /**
     * Create and send app info request to terminal.
     */
    public static HandleMessage appInfoMbca() {
        return (new HandleMessage(HandleOperations.TerminalWrite,
                SLIPFrame.createFrame(new TerminalFrame(
                        TerminalPortApplications.MBCA
                                .getPortApplicationNumber(), BProtocolMessages
                                .getAppInfo()).createFrame())));
    }
}