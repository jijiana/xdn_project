// JavaScript Document
jQuery.extend(jQuery, { 
	// jQuery UI alert弹出提示 
	jqalert: function(text,title,info,fn) { 
		var className = "";
		var color="";
		if(info==1){
			className = "glyphicon glyphicon-ok-circle";
			color="#019c01";
		}else{
			className = "glyphicon glyphicon-remove-circle";
			color="#d73838";
		}
		var html = 
			'<div class="dialog" id="dialog-message" style="height:55px;">' + 
			' <p style="padding: 0px 20px 0px 35px;">' + 
			'<span class="'+className+'" style="font-size: 25px;color: '+color+';top:7px ;"></span>'+
			'  <span class="info" style=""></span>' + text + 
			' </p>' + 
			'</div>'; 
			
		$(html).dialog({
			resizable: false,
			height : 160,
			width : 240,
			modal : true,
			show: {
				effect: 'fade',
				duration: 300
			},
			open: function ()
			{
				//$(this).load('../test.html');
			},
			title: title || "提示信息",
			buttons: {
				"确定": function(){
					var dlg = $(this).dialog("close"); 
					fn && fn.call(dlg); 
				}
			},
			close:function(event, ui){
				$(this).dialog("destroy");
				$("#dialog-message").remove();
			},
		});
		$("#dialog-message").parent().attr("id","dialog-message-p");
	},
	jqalertclose:function(text,title,info,fn) { 
		var className = "";
		var color="";
		if(info==1){
			className = "glyphicon glyphicon-ok-circle";
			color="#019c01";
		}else{
			className = "glyphicon glyphicon-remove-circle";
			color="#d73838";
		}
		var html = 
			'<div class="dialog" id="dialog-message">' + 
			' <p style="padding: 16px 28px 8px 65px;">' + 
			'<span class="'+className+'" style="font-size: 25px;color: '+color+';top:7px ;"></span>'+
			'  <span class="info" style=""></span>' + text + 
			' </p>' + 
			'<p style="padding: 0px 28px 27px 77px;font-size: 12px;"><span id="remain_time">3</span>秒后自动关闭</p>'+
			'</div>'; 
		$(html).dialog({
			resizable: false,
			width : 300,
			modal: true,
			closeOnEscape: false,
			title: title || "提示信息",
			/*open: function (event, ui) {
				$(".ui-dialog-titlebar-close", $(this).parent()).hide();
			},*/	
			buttons: {
				/*"确定": function(){
					var dlg = $(this).dialog("close"); 
					fn && fn.call(dlg); 
				}*/
			}
		});
		$("#dialog-message").parent().attr("id","dialog-message-p");
		var count = 2;
        var timer = setInterval(function(){
          if(count>0){
        	  $("#remain_time").html(count);
        	  count--;
          }else{
        	  $("#dialog-message").remove();
	          clearInterval(timer); //清除计时器
          }
        },1000);
	},
	// jQuery UI confirm弹出确认提示 
	jqconfirm: function(text, title, fn1, fn2) { 
		var html = 
		'<div class="dialog" id="dialog-confirm">' + 
		' <p>' + 
		//' <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>' + text + 
		' <span style="float: left; margin: 0 7px 20px 0;"></span>' + text + 
		' </p>' + 
		'</div>'; 
		return $(html).dialog({ 
			//autoOpen: false, 
			resizable: false, 
			modal: true, 
			show: { 
				effect: 'fade', 
				duration: 300 
			}, 
			title: title || "提示信息", 
			buttons: { 
				"确定": function() { 
					var dlg = $(this).dialog("close"); 
					fn1 && fn1.call(dlg, true); 
				}, 
				"取消": function() { 
					var dlg = $(this).dialog("close"); 
					fn2 && fn2(dlg, false); 
				} 
			},
			close:function(event, ui){
				$(this).dialog("destroy");
				$("#dialog-confirm").remove();
			}
		}); 
		/*$("#dialog-confirm").parent().attr("id","dialog-confirm-p");*/
	}, 
	// jQuery UI 模态dialog框
	jqmybox:{
		show:function(myurl,mytitle,myheight,mywidth) { 
			var html = '<div class="dialog" id="dialog-mybox"></div>'; 
			$(html).dialog({
				resizable: false,
				height: myheight,
      	width: mywidth,
				modal: true,
				show: {effect: 'fade',duration: 300},
				open: function(){$(this).load(myurl);},
				title: mytitle,
				//buttons: dlgbtns,
				close:function(event, ui){
					$(this).dialog("destroy");
					$("#dialog-mybox").remove();
				}
			});
		},
		hide:function(){
			$("#dialog-mybox").dialog("close");
		}
	},
})