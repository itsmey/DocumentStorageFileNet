package ru.bikert.fileNet.operationUI;

interface UIConstants {

    interface NameOperation{
        String DELETE = "Удалить";
        String СREATE = "Создать";
        String DOWNLOAD = "Выгрузить вложение";
        String EDIT = "Изменить вложение";
        String REPORT = "Отчет по документам";
        String TRANSFER = "Движение документа";
    }

    interface KeyOperation {
        String DELETE = "delete";
        String СREATE = "create";
        String DOWNLOAD = "Download";
        String EDIT = "Edit";
        String REPORT = "Report";
        String TRANSFER = "Transfer";
    }

    interface DocumentClass{
        String ORDER = "Order";
        String CONTRACT = "Contract";
        String STATEMENTS = "Statements";
    }
    interface FolderNames{
        String ORDER = "приказы";
        String CONTRACT = "договоры";
        String STATEMENTS = "заявления";
    }
    interface PropertyFileNet{
        String dateApproval = "dateApproval";           //Дата утверждения
        String documentStatus = "documentStatus";       //Статус документа
        String numberDocument = "numberDocument";       //Номер документа
        String Responsible = "Responsible1";            //Ответственный
        String receiptDate = "receiptDate";             //Дата поступления
        String Counterparty="Counterparty";             //Контрагент
        String DocumentTitle = "DocumentTitle";
    }
}
