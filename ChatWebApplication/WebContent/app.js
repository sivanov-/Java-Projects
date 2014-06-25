var username;

var appendToAllMessages = function(str) {
	var allMessagesField = Ext.getCmp('allMessages');
	if (str && allMessagesField) {
		var oldValue = allMessagesField.getValue();
		if (oldValue.length > 0) {
			oldValue += '\n';
		}
		allMessagesField.setValue(oldValue + str);	
	}
};

var checkNewMessageTask = Ext.util.TaskManager.newTask({
	run: function() {
		Ext.Ajax.request({
			url : 'getMsg',
			success : function(response) {
				appendToAllMessages(response.responseText);
			}
		});
	},
	interval: 3000
});

Ext.application({
    name: 'HelloExt',
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'absolute',
            margin: 50,
            items: [
                // Login panel
                {
                	id: 'loginPanel',
                	xtype: 'panel',
                    title: 'Login',
                    height: 200,
                    width: 300,
                    layout: 'form',
                    bodyPadding: 15,
                    items: [
                        {
                        	id: 'usernameField',
                        	xtype: 'textfield',
                        	allowBlank: false,
                        	fieldLabel: 'Username'
                        }, {
                        	xtype: 'button',
                        	text: 'Login',
                        	handler: function() {
                        		
                        		var field = Ext.getCmp('usernameField');
                        		username = field.getValue();
                        		
                        		Ext.Ajax.request({
                        			url: 'login',
                        			params: {
                        				user: username
                        			},
                        			success: function(response){
                        				var loginPanel = Ext.getCmp('loginPanel');
                        				loginPanel.hide();
                        				
                        				var chatPanel = Ext.getCmp('chatPanel');
                        				chatPanel.show();
                        				checkNewMessageTask.start();
                        			}
                        		});
                        	}
                        }
                    ]
                },
                
                // Chat panel
                {
                	id: 'chatPanel',
                	xtype: 'panel',
                    title: 'Chat',
                    height: 600,
                    width: 300,
                    layout: 'anchor',
                    hidden: true,
                    items: [
                        {
                        	id: 'allMessages',
                        	xtype: 'textarea',
                        	anchor: '0, -100',
                        	readOnly: true
                        }, {
                        	id: 'message',
                        	xtype: 'textarea',
                        	anchor: '100%',
                        	height: 90
                        }
                    ],
                    bbar: [
                       '->',
                       {
                    	   xtype: 'button',
                    	   text: 'Send',
                    	   handler: function() {
                    		   
                    		   var allMessagesField = Ext.getCmp('allMessages');
                    		   var messageField = Ext.getCmp('message');
                    		   if (messageField.getValue().length == 0) {
                    			   return;
                    		   }
                    		   
	                		   Ext.Ajax.request({
									url : 'sendMsg',
									params : {
										msg : messageField.getValue()
									},
									success : function(response) {
										appendToAllMessages(username + ': ' + messageField.getValue());
										messageField.setValue('');
									}
								});
                		   }
                       }
                   ]
                }
            ]
        });
    }
});