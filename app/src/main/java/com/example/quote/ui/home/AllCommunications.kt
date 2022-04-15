package com.example.quote.ui.home

interface SuccessCommunication : QuoteCommunication<String> {
    class Base : QuoteCommunication.Base<String>(), SuccessCommunication
}

interface ProgressCommunication : QuoteCommunication<Boolean> {
    class Base : QuoteCommunication.Base<Boolean>(), ProgressCommunication
}

interface ErrorCommunication : QuoteCommunication<String> {
    class Base : QuoteCommunication.Base<String>(), ErrorCommunication
}