import React from 'react'
import { useTodayTodos } from '../context/TodayTodoContext';
import { DashboardCard, DashboardRow, Label, Span } from './Home.styled';

const Home = () => {
    const { todayTodos, setTodayTodos } = useTodayTodos();
    const allCnt = todayTodos.length;
    const progCnt = todayTodos.filter(t => t.status ==='progess').length;
    const doneCnt = todayTodos.filter(t => t.status ==='done').length;
    const workCnt = todayTodos.filter(t => t.category ==='work').length;
    const perCnt = todayTodos.filter(t => t.category ==='personal').length;
    const studyCnt = todayTodos.filter(t => t.category ==='study').length;
    return (
        <>
            <h1>Home</h1>
            <DashboardRow>
                <DashboardCard>
                    <Label>전체</Label>
                    <br/>
                    <Span>{allCnt}</Span>
                </DashboardCard>
                <DashboardCard>
                    <Label>진행중</Label>
                    <br/>
                    <Span>{progCnt}</Span>
                </DashboardCard>
                <DashboardCard>
                    <Label>완료</Label>
                    <br/>
                    <Span>{doneCnt}</Span>
                </DashboardCard>
            </DashboardRow>
            <DashboardRow>
                <DashboardCard>
                    <Label>work</Label>
                    <br/>
                    <Span>{workCnt}</Span>
                </DashboardCard>
                <DashboardCard>
                    <Label>personal</Label>
                    <br/>
                    <Span>{perCnt}</Span>
                </DashboardCard>
                <DashboardCard>
                    <Label>study</Label>
                    <br/>
                    <Span>{studyCnt}</Span>
                </DashboardCard>
                
            </DashboardRow>
        </>
    )
}

export default Home