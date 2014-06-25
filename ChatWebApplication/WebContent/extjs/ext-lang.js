/*
This file is part of Ext JS 4.2

Copyright (c) 2011-2013 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as
published by the Free Software Foundation and appearing in the file LICENSE included in the
packaging of this file.

Please review the following information to ensure the GNU General Public License version 3.0
requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department
at http://www.sencha.com/contact.

Build date: 2013-03-11 22:33:40 (aed16176e68b5e8aa1433452b12805c0ad913836)
*/
/**
 * List compiled by mystix on the extjs.com forums.
 * Thank you Mystix!
 *
 * English Translations
 * updated to 2.2 by Condor (8 Aug 2008)
 */
Ext.onReady(function() {
    var cm = Ext.ClassManager,
        exists = Ext.Function.bind(cm.get, cm);

    if (Ext.Updater) {
        Ext.Updater.defaults.indicatorText = '<div class="loading-indicator">'+bundle['extjs.UpdateManager.defaults.indicatorText']+'</div>';
    }

    if (exists('Ext.data.Types')) {
        Ext.data.Types.stripRe = /[\$,%]/g;
    }

    if (Ext.Date) {
        Ext.Date.monthNames = [
           bundle['extjs.monthNames.January'],
           bundle['extjs.monthNames.February'],
           bundle['extjs.monthNames.March'],
           bundle['extjs.monthNames.April'],
           bundle['extjs.monthNames.May'],
           bundle['extjs.monthNames.June'],
           bundle['extjs.monthNames.July'],
           bundle['extjs.monthNames.August'],
           bundle['extjs.monthNames.September'],
           bundle['extjs.monthNames.October'],
           bundle['extjs.monthNames.November'],
           bundle['extjs.monthNames.December']
        ];

        Ext.Date.shortMonthNames = [
           bundle['extjs.shortMonthNames.January'],
           bundle['extjs.shortMonthNames.February'],
           bundle['extjs.shortMonthNames.March'],
           bundle['extjs.shortMonthNames.April'],
           bundle['extjs.shortMonthNames.May'],
           bundle['extjs.shortMonthNames.June'],
           bundle['extjs.shortMonthNames.July'],
           bundle['extjs.shortMonthNames.August'],
           bundle['extjs.shortMonthNames.September'],
           bundle['extjs.shortMonthNames.October'],
           bundle['extjs.shortMonthNames.November'],
           bundle['extjs.shortMonthNames.December']
        ];

        Ext.Date.getShortMonthName = function(month) {
            return Ext.Date.shortMonthNames[month];
        };

        Ext.Date.monthNumbers = {
            Jan: 0,
            Feb: 1,
            Mar: 2,
            Apr: 3,
            May: 4,
            Jun: 5,
            Jul: 6,
            Aug: 7,
            Sep: 8,
            Oct: 9,
            Nov: 10,
            Dec: 11
        };

        Ext.Date.getMonthNumber = function(name) {
            return Ext.Date.monthNumbers[name.substring(0, 1).toUpperCase() + name.substring(1, 3).toLowerCase()];
        };

        Ext.Date.dayNames = [
           bundle['extjs.dayNames.Sunday'],
           bundle['extjs.dayNames.Monday'],
           bundle['extjs.dayNames.Tuesday'],
           bundle['extjs.dayNames.Wednesday'],
           bundle['extjs.dayNames.Thursday'],
           bundle['extjs.dayNames.Friday'],
           bundle['extjs.dayNames.Saturday']
        ];

        Ext.Date.getShortDayName = function(day) {
            return Ext.Date.dayNames[day].substring(0, 3);
        };

        Ext.Date.parseCodes.S.s = "(?:st|nd|rd|th)";

        Ext.Date.parseCodes.a = {
            g: 1,
            c: "if (/(" + bundle['extjs.am'] + ")/i.test(results[{0}])) {\n"
                + "if (!h || h == 12) { h = 0; }\n"
                + "} else { if (!h || h < 12) { h = (h || 0) + 12; }}",
            s: "(" + bundle['extjs.am'] + "|" + bundle['extjs.pm']
               + "|" + bundle['extjs.AM'] + "|" + bundle['extjs.PM']+")",
            calcAtEnd: true
        };

        Ext.Date.parseCodes.A = {
            g: 1,
            c: "if (/(" + bundle['extjs.am'] + ")/i.test(results[{0}])) {\n"
                + "if (!h || h == 12) { h = 0; }\n"
                + "} else { if (!h || h < 12) { h = (h || 0) + 12; }}",
            s: "(" + bundle['extjs.AM'] + "|" + bundle['extjs.PM']
               + "|" + bundle['extjs.am'] + "|" + bundle['extjs.pm']+")",
            calcAtEnd: true
        };

        Ext.Date.formatCodes.a = "(this.getHours() < 12 ? '" + bundle['extjs.am'] +"' : '" + bundle['extjs.pm'] + "')";
        Ext.Date.formatCodes.A = "(this.getHours() < 12 ? '" + bundle['extjs.AM'] +"' : '" + bundle['extjs.PM'] + "')";
    }

    if (Ext.picker.Date) {
        Ext.picker.Date.dayInitials = {};
        Ext.picker.Date.dayInitials[bundle['extjs.dayNames.Sunday']] = bundle['extjs.dayInitials.Sunday'];
        Ext.picker.Date.dayInitials[bundle['extjs.dayNames.Monday']] = bundle['extjs.dayInitials.Monday'];
        Ext.picker.Date.dayInitials[bundle['extjs.dayNames.Tuesday']] = bundle['extjs.dayInitials.Tuesday'];
        Ext.picker.Date.dayInitials[bundle['extjs.dayNames.Wednesday']] = bundle['extjs.dayInitials.Wednesday'];
        Ext.picker.Date.dayInitials[bundle['extjs.dayNames.Thursday']] = bundle['extjs.dayInitials.Thursday'];
        Ext.picker.Date.dayInitials[bundle['extjs.dayNames.Friday']] = bundle['extjs.dayInitials.Friday'];
        Ext.picker.Date.dayInitials[bundle['extjs.dayNames.Saturday']] = bundle['extjs.dayInitials.Saturday'];

        Ext.override(Ext.picker.Date, {
            getDayInitial: function (value) {
                return Ext.picker.Date.dayInitials[value];
            }
        });
    }

    if (Ext.MessageBox) {
        Ext.MessageBox.buttonText = {
            ok: bundle['extjs.MessageBox.buttonText.ok'],
            cancel: bundle['extjs.MessageBox.buttonText.cancel'],
            yes: bundle['extjs.MessageBox.buttonText.yes'],
            no: bundle['extjs.MessageBox.buttonText.no']
        };
    }
/*
    if (exists('Ext.util.Format')) {
        Ext.apply(Ext.util.Format, {
            thousandSeparator: ',',
            decimalSeparator: '.',
            currencySign: '$',
            dateFormat: 'm/d/Y'
        });
    }
*/
    if (exists('Ext.form.field.VTypes')) {
        Ext.apply(Ext.form.field.VTypes, {
            emailText    : bundle['extjs.form.VTypes.emailText'],
            urlText      : bundle['extjs.form.VTypes.urlText'],
            alphaText    : bundle['extjs.form.VTypes.alphaText'],
            alphanumText : bundle['extjs.form.VTypes.alphanumText']
        });
    }

    // Tooltip issue in IE11 - http://www.sencha.com/forum/showthread.php?260683
    if(Ext.isIE11) {
        Ext.supports.Direct2DBug = true;
    }
});
/*
Ext.define("Ext.view.View", {
    override: "Ext.view.View",
    emptyText: ""
});
*/

Ext.define("Ext.grid.plugin.RowEditing", {
    override: "Ext.grid.plugin.RowEditing",
    saveBtnText  : bundle['extjs.grid.plugin.RowEditing.saveBtnText'],
    cancelBtnText: bundle['extjs.grid.plugin.RowEditing.cancelBtnText'],
    errorsText: bundle['extjs.grid.plugin.RowEditing.errorsText'],
    dirtyText: bundle['extjs.grid.plugin.RowEditing.dirtyText']
});

Ext.define("Ext.grid.plugin.DragDrop", {
    override: "Ext.grid.plugin.DragDrop",
    dragText: bundle['extjs.grid.GridPanel.prototype.ddText']
});

Ext.override(Ext.tree.plugin.TreeViewDragDrop, {
    dragText: bundle['extjs.tree.TreePanel.prototype.ddText']
});

// changing the msg text below will affect the LoadMask
Ext.define("Ext.view.AbstractView", {
    override: "Ext.view.AbstractView",
    loadingText: bundle['extjs.UpdateManager.defaults.indicatorText'],
    msg: bundle['extjs.LoadMask.prototype.msg']
});

Ext.override(Ext.LoadMask, {
    'msg' : bundle['main.loading']
});

Ext.define("Ext.picker.Date", {
    override: "Ext.picker.Date",
    todayText         : bundle['extjs.DatePicker.todayText'],
    minText           : bundle['extjs.DatePicker.minText'],
    maxText           : bundle['extjs.DatePicker.maxText'],
    disabledDaysText  : "",
    disabledDatesText : "",
    monthNames        : Date.monthNames,
    dayNames          : Date.dayNames,
    nextText          : bundle['extjs.DatePicker.nextText'],
    prevText          : bundle['extjs.DatePicker.prevText'],
    monthYearText     : bundle['extjs.DatePicker.monthYearText'],
    todayTip          : bundle['extjs.DatePicker.todayTip'],
    format            : bundle['dateTimeFormatStrings.shortDateFormat'],
    longDayFormat     : bundle['dateTimeFormatStrings.mediumDateFormat'],
    monthYearFormat   : bundle['extjs.DatePicker.monthYearFormat']
});

Ext.define("Ext.picker.Month", {
    override: "Ext.picker.Month",
    okText: bundle['extjs.DatePicker.okText'],
    cancelText: bundle['extjs.DatePicker.cancelText']
});

Ext.define("Ext.toolbar.Paging", {
    override: "Ext.PagingToolbar",
    beforePageText : bundle['extjs.PagingToolbar.beforePageText'],
    afterPageText  : bundle['extjs.PagingToolbar.afterPageText'],
    firstText      : bundle['extjs.PagingToolbar.firstText'],
    prevText       : bundle['extjs.PagingToolbar.prevText'],
    nextText       : bundle['extjs.PagingToolbar.nextText'],
    lastText       : bundle['extjs.PagingToolbar.lastText'],
    refreshText    : bundle['extjs.PagingToolbar.refreshText'],
    displayMsg     : bundle['extjs.PagingToolbar.displayMsg'],
    emptyMsg       : bundle['extjs.PagingToolbar.emptyMsg']
});

Ext.define("Ext.form.Basic", {
    override: "Ext.form.Basic",
    waitTitle: bundle['extjs.form.BasicForm.waitTitle']
});

Ext.define("Ext.form.field.Base", {
    override: "Ext.form.field.Base",
    invalidText: bundle['extjs.form.Field.invalidText']
});

Ext.define("Ext.form.field.Text", {
    override: "Ext.form.field.Text",
    minLengthText : bundle['extjs.form.TextField.minLengthText'],
    maxLengthText : bundle['extjs.form.TextField.maxLengthText'],
    blankText     : bundle['extjs.form.TextField.blankText'],
    regexText     : "",
    emptyText     : null
});

Ext.define("Ext.form.field.Number", {
    override: "Ext.form.field.Number",
    // decimalSeparator: ".",
    // decimalPrecision: 2,
    minText : bundle['extjs.form.NumberField.minText'],
    maxText : bundle['extjs.form.NumberField.maxText'],
    nanText : bundle['extjs.form.NumberField.nanText'],
    negativeText : bundle['extjs.form.negativeText']
});

Ext.define("Ext.form.field.Date", {
    override: "Ext.form.field.Date",
    disabledDaysText  : bundle['extjs.form.DateField.disabledDaysText'],
    disabledDatesText : bundle['extjs.form.DateField.disabledDatesText'],
    minText           : bundle['extjs.form.DateField.minText'],
    maxText           : bundle['extjs.form.DateField.maxText'],
    invalidText       : bundle['extjs.form.DateField.invalidText']
    // format            : "m/d/y",
    // altFormats        : "m/d/Y|m-d-y|m-d-Y|m/d|m-d|md|mdy|mdY|d|Y-m-d",
});

Ext.define("Ext.form.field.ComboBox", {
    override: "Ext.form.field.ComboBox",
    valueNotFoundText: undefined
}, function() {
    Ext.apply(Ext.form.field.ComboBox.prototype.defaultListConfig, {
        loadingText: bundle['extjs.form.ComboBox.loadingText']
    });
});

Ext.define("Ext.form.field.HtmlEditor", {
    override: "Ext.form.field.HtmlEditor",
    createLinkText: 'Please enter the URL for the link:'
}, function() {
    Ext.apply(Ext.form.field.HtmlEditor.prototype, {
        buttonTips: {
            bold: {
                title: 'Bold (Ctrl+B)',
                text: 'Make the selected text bold.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            italic: {
                title: 'Italic (Ctrl+I)',
                text: 'Make the selected text italic.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            underline: {
                title: 'Underline (Ctrl+U)',
                text: 'Underline the selected text.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            increasefontsize: {
                title: 'Grow Text',
                text: 'Increase the font size.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            decreasefontsize: {
                title: 'Shrink Text',
                text: 'Decrease the font size.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            backcolor: {
                title: 'Text Highlight Color',
                text: 'Change the background color of the selected text.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            forecolor: {
                title: 'Font Color',
                text: 'Change the color of the selected text.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            justifyleft: {
                title: 'Align Text Left',
                text: 'Align text to the left.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            justifycenter: {
                title: 'Center Text',
                text: 'Center text in the editor.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            justifyright: {
                title: 'Align Text Right',
                text: 'Align text to the right.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            insertunorderedlist: {
                title: 'Bullet List',
                text: 'Start a bulleted list.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            insertorderedlist: {
                title: 'Numbered List',
                text: 'Start a numbered list.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            createlink: {
                title: 'Hyperlink',
                text: 'Make the selected text a hyperlink.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            },
            sourceedit: {
                title: 'Source Edit',
                text: 'Switch to source editing mode.',
                cls: Ext.baseCSSPrefix + 'html-editor-tip'
            }
        }
    });
});

Ext.define("Ext.grid.header.Container", {
    override: "Ext.grid.header.Container",
    sortAscText  : bundle['extjs.grid.GridView.sortAscText'],
    sortDescText : bundle['extjs.grid.GridView.sortDescText'],
    columnsText  : bundle['extjs.grid.GridView.columnsText']
});

Ext.define("Ext.grid.locking.Lockable", {
    override: "Ext.grid.locking.Lockable",
    unlockText   : bundle['extjs.grid.locking.Lockable.unlockText'],
    lockText     : bundle['extjs.grid.locking.Lockable.lockText']
});

/*
Ext.define("Ext.grid.GroupingFeature", {
    override: "Ext.grid.GroupingFeature",
    emptyGroupText : bundle['extjs.grid.GroupingView.emptyGroupText'],
    groupByText    : bundle['extjs.grid.GroupingView.groupByText'],
    showGroupsText : bundle['extjs.grid.GroupingView.showGroupsText']
});
*/

Ext.define("Ext.grid.PropertyColumnModel", {
    override: "Ext.grid.PropertyColumnModel",
    nameText   : bundle['extjs.grid.PropertyColumnModel.nameText'],
    valueText  : bundle['extjs.grid.PropertyColumnModel.valueText']
    //dateFormat : "m/j/Y",
    //trueText   : "true",
    //falseText  : "false"
});

/*
Ext.define("Ext.grid.BooleanColumn", {
    override: "Ext.grid.BooleanColumn",
    trueText: "true",
    falseText: "false",
    undefinedText: '&#160;'
});

Ext.define("Ext.grid.NumberColumn", {
    override: "Ext.grid.NumberColumn",
    format: '0,000.00'
});

Ext.define("Ext.grid.DateColumn", {
    override: "Ext.grid.DateColumn",
    format: 'm/d/Y'
});
*/

Ext.define("Ext.form.field.Time", {
    override: "Ext.form.field.Time",
    minText : bundle['extjs.form.TimeField.minText'],
    maxText : bundle['extjs.form.TimeField.maxText'],
    invalidText : bundle['extjs.form.TimeField.invalidText']
    //format : "g:i A",
    //altFormats : "g:ia|g:iA|g:i a|g:i A|h:i|g:i|H:i|ga|ha|gA|h a|g a|g A|gi|hi|gia|hia|g|H"
});

Ext.define("Ext.form.CheckboxGroup", {
    override: "Ext.form.CheckboxGroup",
    blankText : bundle['extjs.form.CheckboxGroup.blankText']
});

Ext.define("Ext.grid.column.Action", {
    override: "Ext.grid.column.Action",
    menuText: '<i>' + bundle['extjs.grid.ActionColumn.menuText'] + '</i>'
});

Ext.define("Ext.form.RadioGroup", {
    override: "Ext.form.RadioGroup",
    blankText : bundle['extjs.form.RadioGroup.blankText']
});

Ext.override(Ext.form.field.File, {
    buttonText : bundle['extjs.buttonUploadText']
});

Ext.define("Ext.grid.RowEditor", {
    override: "Ext.grid.RowEditor",
    errorsText : bundle['extjs.grid.RowEditor.errorsText'],
    saveBtnText : bundle['extjs.grid.RowEditor.saveBtnText'],
    cancelBtnText : bundle['extjs.grid.RowEditor.cancelBtnText']
});

// This is needed until we can refactor all of the locales into individual files
Ext.define("Ext.Component", {
    override: "Ext.Component"
});

