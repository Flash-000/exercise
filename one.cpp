#include<stdio.h>
#include<stdlib.h>
typedef struct LinkList {
	int coef, exp;
	struct LinkList* next;
}LinkList;
LinkList* create(LinkList* head);
void merge(LinkList* L1, LinkList* L2);
void outPut(LinkList* head);
int main(void) {
	LinkList* List1=NULL;
	LinkList* List2 = NULL;
	List1=create(List1);
	List2 = create(List2);
	merge(List1, List2);
	outPut(List1);
	return 0;
}
//��ʼ������ʽ
LinkList* create(LinkList* head) {
	head = (LinkList*)malloc(sizeof(LinkList));
	LinkList* p;
	p = head;
	LinkList* number;
	int flag = 1;
	int coef, exp,m;
	printf("���������ʽ������:");
	scanf_s("%d", &m);
	for (int i = 0; i < m; i++) {
		printf("�������%d���ϵ����ָ��:", (i + 1));
		scanf("%d %d", &coef, &exp);
		number = (LinkList*)malloc(sizeof(LinkList));
		number->coef = coef;
		number->exp = exp;
		p->next = number;
		p = number;
	}
	p->next = NULL;
	return head;
}
//�������ʽ
void outPut(LinkList* head) {
	LinkList* p;
	p = head->next;
	if (p == NULL) {
		printf("������Ϊ��");
	}
	while(p!=NULL){
		printf("%d*^%d+",p->coef,p->exp);
		p = p->next;
	}
}
//����ʽ���
void merge(LinkList* L1, LinkList* L2) {
	LinkList* p, * q,*tail,*temp;
	int sum;
	p = L1->next;
	q = L2->next;
	tail = L1;
	while (p != NULL && q != NULL) {
		if (p->exp<q->exp) {
			tail->next = p;
			tail = p;
			p = p->next;
		}
		else if (p->exp == q->exp) {
			sum = p->coef + q->coef;
			if (sum != 0) {
				p->coef = sum;
				tail->next = p;
				tail = p;
				p = p->next;
				temp = q;
				q = q->next;
				free(temp);
			}
			else {
				temp = p;
				p = p->next;
				free(temp);
				temp = q;
				q = q->next;
				free(temp);
			}
		}
		else {
			tail->next =q;
			tail =q;
			q = q->next;
		}
	}
	if (p != NULL) {
		tail->next = p;
	}
	else {
		tail->next = q;
	}
}